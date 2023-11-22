package com.mobilearchitects.signtospeak.ui.Retrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface RetrofitApi {
        @FormUrlEncoded
        @POST("/token")
        suspend fun login(
            @Field("username") username: String,
            @Field("password") password: String
        ): Response<Token>

        @GET("/users/me/")
        suspend fun getUserDetails(
            @Header("Authorization") token: String
        ): Response<UserResponse>

        @POST("/signup")
        suspend fun signUp(
            @Body newUser: UserResponse
        ): Response<UserResponse>

    @GET("/test-database")
    suspend fun testDB():Response<Test>

        // Add other endpoints similarly
    }
