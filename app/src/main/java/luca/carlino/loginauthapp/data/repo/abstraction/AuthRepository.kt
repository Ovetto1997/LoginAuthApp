package luca.carlino.loginauthapp.data.repo.abstraction

import luca.carlino.loginauthapp.domain.models.AuthResult

interface AuthRepository {
    suspend fun login(username: String, password: String): AuthResult

}