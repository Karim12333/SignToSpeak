from datetime import datetime, timedelta
from typing import Annotated

from fastapi import Depends, FastAPI, HTTPException, status
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from jose import JWTError, jwt
from passlib.context import CryptContext
from sqlalchemy.orm import Session

from Backend.models import Token, TokenData, User, UserResponse 
from Backend.database import engine, SessionLocal, Base
from pydantic import EmailStr


# to get a string like this run:
# openssl rand -hex 32
SECRET_KEY = "5f3a145ed1f5ec5f46e090793825a05dfedb566d5af6e845764db7db224c4167"
ALGORITHM = "HS256"
ACCESS_TOKEN_EXPIRE_MINUTES = 30

# Dependency to get the database session
def get_database(): 
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

Base.metadata.create_all(bind=engine)


pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

app = FastAPI()

def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)

def get_password_hash(password):
    return pwd_context.hash(password)

def get_user(db: Session, username: str):
    return db.query(User).filter(User.username == username).first()

def authenticate_user(db: Session, username: str, password: str):
    user = get_user(db, username)
    if not user or not verify_password(password, user.hashed_password):
        return False
    return user

def create_access_token(data: dict, expires_delta: timedelta | None = None):
    to_encode = data.copy()
    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.utcnow() + timedelta(minutes=15)
    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt

async def get_current_user(token: Annotated[str, Depends(oauth2_scheme)], db: Session = Depends(get_database)):
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"},
    )
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        if username is None:
            raise credentials_exception
        token_data = TokenData(username=username)
    except JWTError:
        raise credentials_exception
    user = get_user(db, username=token_data.username)
    if user is None:
        raise credentials_exception
    return user

async def get_current_active_user(current_user: Annotated[User, Depends(get_current_user)]):
    if current_user.disabled:
        raise HTTPException(status_code=400, detail="Inactive user")
    return current_user

@app.post("/token", response_model=Token)
async def login_for_access_token(form_data: Annotated[OAuth2PasswordRequestForm, Depends()], db: Session = Depends(get_database)):
    user = authenticate_user(db, form_data.username, form_data.password)
    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Incorrect username or password",
            headers={"WWW-Authenticate": "Bearer"}, 
        )
    access_token_expires = timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    access_token = create_access_token(data={"sub": user.username}, expires_delta=access_token_expires)
    return {"access_token": access_token, "token_type": "bearer"}

@app.get("/users/me/", response_model=UserResponse)  
async def read_users_me(current_user: Annotated[User, Depends(get_current_active_user)]):
    return current_user


# @app.get("/users/me/items/")
# async def read_own_items(current_user: Annotated[User, Depends(get_current_active_user)]):
#     return [{"item_id": "Foo", "owner": current_user.username}]

@app.post("/signup", response_model=UserResponse)
async def signup(
    first_name: str,
    last_name: str,
    username: str,
    email: EmailStr,
    password: str,
    disabled: bool = False,
    db: Session = Depends(get_database) 
): 
    print(f"Received data: {first_name}, {last_name}, {username}, {email}, {password}, {disabled}")
    # Check if username or email already exists
    if (
        db.query(User).filter(User.username == username).first() is not None
        or db.query(User).filter(User.email == email).first() is not None
    ):
        raise HTTPException(
            status_code=400, 
            detail="Username or email already registered",
        )

    hashed_password = get_password_hash(password)
    user = User(
        first_name = first_name,
        last_name = last_name,
        username=username,
        email=email,
        hashed_password=hashed_password,
        disabled=disabled,
    )
    db.add(user)
    db.commit()
    db.refresh(user)

    return UserResponse.from_orm(user)  


# Endpoint to test the database connection
@app.get("/test-database")
async def test_database(db: Session = Depends(get_database)):
    try:
        # Querying a user from the database
        user = db.query(User).first()
        if user:
            user_response = UserResponse.from_orm(user)
            return {"message": "Database connection successful", "user": user_response.dict()}
        else:
            return {"message": "Database is empty"}
    except Exception as e:
        print(f"Exception: {e}")
        raise HTTPException(status_code=500, detail=f"Database error: {str(e)}")
