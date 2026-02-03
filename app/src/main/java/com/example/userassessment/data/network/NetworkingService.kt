package com.example.userassessment.data.network

import com.example.userassessment.data.model.HomeResponse
import com.example.userassessment.data.model.LoginResponse
import com.example.userassessment.data.model.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkingService {
    @FormUrlEncoded
    @POST("register")
    suspend fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("role") role: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("home")
    suspend fun getHome(): HomeResponse
}