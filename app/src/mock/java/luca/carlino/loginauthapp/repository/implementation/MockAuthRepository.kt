package luca.carlino.loginauthapp.repository.implementation

import luca.carlino.loginauthapp.data.AuthRemoteDatasource
import luca.carlino.loginauthapp.data.AuthRemoteResult
import luca.carlino.loginauthapp.data.repository.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import javax.inject.Inject

class MockAuthRepository @Inject constructor(
    private val remote: AuthRemoteDatasource
) : AuthRepository {

    override suspend fun login(email: String, password: String): AuthResult {
        return when (val r = remote.login(email, password)) {
            is AuthRemoteResult.Ok -> AuthResult.Success
            is AuthRemoteResult.Error -> when (r.code) {
                AuthRemoteResult.Code.EMAIL_MISMATCH ->
                    AuthResult.Failure(emailError = "Mock: email mismatch")
                AuthRemoteResult.Code.PASSWORD_INCORRECT ->
                    AuthResult.Failure(passwordError = "Mock: wrong password")
            }
        }
    }
}