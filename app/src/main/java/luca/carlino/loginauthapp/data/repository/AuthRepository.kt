package luca.carlino.loginauthapp.data.repository

import luca.carlino.loginauthapp.domain.models.AuthResult


interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResult

}