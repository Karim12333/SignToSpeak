from sqlalchemy import Column, String, Boolean
from sqlalchemy.ext.declarative import declarative_base
from pydantic import BaseModel


Base = declarative_base()


class User(Base):
    __tablename__ = "User"
    __table_args__ = {"schema": "signtospeak", 'extend_existing': True}

    first_name = Column(String, nullable=True)
    last_name = Column(String, nullable=True)
    username = Column(String, primary_key=True, index=True)
    email = Column(String, index=True, nullable=True)
    hashed_password = Column(String, nullable=True)
    disabled = Column(Boolean, default=False, nullable=True)
    

class UserResponse(BaseModel):  
    first_name: str
    last_name: str
    username: str
    email: str | None = None
    hashed_password: str | None = None
    disabled: bool
    

    @classmethod
    def from_orm(cls, user: User):
        return cls(
            first_name = user.first_name,
            last_name = user.last_name,
            username=user.username,
            email=user.email,
            hashed_password=user.hashed_password,
            disabled=user.disabled,
        )
    
class Token(BaseModel):
    access_token: str
    token_type: str


class TokenData(BaseModel):
    username: str | None = None

