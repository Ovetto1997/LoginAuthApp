package luca.carlino.loginauthapp.data

import luca.carlino.loginauthapp.data.AuthRemoteResult

interface AuthRemoteDatasource {
    suspend fun login(email: String, password: String): AuthRemoteResult
}