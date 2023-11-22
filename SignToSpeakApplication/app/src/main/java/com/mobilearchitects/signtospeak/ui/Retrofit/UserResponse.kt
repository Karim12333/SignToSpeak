package com.mobilearchitects.signtospeak.ui.Retrofit

data class UserResponse(
    val firstName: String?,
    val lastName: String?,
    val username: String, // primary key, hence non-nullable
    val email: String?,
    val hashedPassword: String?,
    val disabled: Boolean?
)



