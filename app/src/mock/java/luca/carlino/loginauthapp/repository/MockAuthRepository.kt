package luca.carlino.loginauthapp.repository

import kotlinx.coroutines.delay
import luca.carlino.loginauthapp.data.repo.abstraction.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import javax.inject.Inject

class MockAuthRepository @Inject constructor(): AuthRepository {
    override suspend fun login(username: String, password: String): AuthResult {
        delay(250)

        val u = BuildConfig.MOCK_USER
        val p = BuildConfig.MOCK_PASS

        val userOk = username == u
        val passOk = password == p

        return if (userOk && passOk) AuthResult.Success
        else AuthResult.Failure(
            usernameError = if (!userOk) "Unknown username" else null,
            passwordError = if (!passOk) "Incorrect password" else null
    }
}