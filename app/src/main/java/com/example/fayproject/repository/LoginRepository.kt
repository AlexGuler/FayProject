package com.example.fayproject.repository

import com.example.fayproject.models.ObservableData
import com.example.fayproject.models.login.LoginRequest
import com.example.fayproject.models.login.LoginResult
import com.example.fayproject.network.FayNetworkService
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

interface LoginRepository {
    fun login(userName: String, password: String): Flow<ObservableData<LoginResult>>
}

class LoginRepositoryImpl @Inject constructor(
    private val fayNetworkService: FayNetworkService
) : LoginRepository {

    override fun login(userName: String, password: String): Flow<ObservableData<LoginResult>> {
        return flow {
            val result = fayNetworkService.login(LoginRequest(userName, password))
            val loginResult = result.body()

            if (result.isSuccessful && loginResult != null) {
                emit(ObservableData.Data(loginResult))
            } else {
                emit(ObservableData.Error(Exception("Error occurred with code: ${result.code()}, messsage: ${result.errorBody()}")))
            }
        }.onStart {
            emit(ObservableData.Loading)
        }.catch { throwable ->
            emit(ObservableData.Error(throwable))
        }
    }
}
