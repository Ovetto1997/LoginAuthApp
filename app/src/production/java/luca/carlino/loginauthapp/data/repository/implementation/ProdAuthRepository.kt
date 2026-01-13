package luca.carlino.loginauthapp.data.repository.implementation

import luca.carlino.loginauthapp.data.repo.abstraction.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import javax.inject.Inject

class ProdAuthRepository @Inject constructor() : AuthRepository {
    override suspend fun login(username: String, password: String): AuthResult {

        val userOk = username == BuildConfig.PROD_USER
        val passOk = password == BuildConfig.PROD_PASS

        return if (userOk && passOk) AuthResult.Success
        else AuthResult.Failure(
            usernameError = if (!userOk) "Username not recognized" else null,
            passwordError = if (!passOk) "Password invalid" else null
        )
    }
}