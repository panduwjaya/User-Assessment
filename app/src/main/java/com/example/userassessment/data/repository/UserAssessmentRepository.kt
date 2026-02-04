package com.example.userassessment.data.repository

import com.example.userassessment.data.model.HomeResponse
import com.example.userassessment.data.model.LoginResponse
import com.example.userassessment.data.model.RegisterResponse
import com.example.userassessment.data.network.NetworkingService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton
import com.example.userassessment.ui.util.Result
import com.example.userassessment.ui.util.TokenManager

@Singleton
class UserAssessmentRepository @Inject constructor(
    private val networkingService: NetworkingService,
    private val tokenManager: TokenManager
){
    fun fetchLogin(name: String, email: String): Flow<Result<LoginResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.postLogin(name,email)
            val accessToken = response.accesToken
            tokenManager.saveTokens(accessToken)
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, LoginResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchRegister(name: String, email: String, password: String,role: String): Flow<Result<RegisterResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.postRegister(name,email,password,role)
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, RegisterResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchHome(): Flow<Result<HomeResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.getHome()
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, HomeResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)
}