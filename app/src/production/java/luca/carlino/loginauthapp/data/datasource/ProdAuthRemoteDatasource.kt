package luca.carlino.loginauthapp.data.repository.implementation

import kotlinx.coroutines.delay
import luca.carlino.loginauthapp.data.AuthRemoteDatasource
import luca.carlino.loginauthapp.data.AuthRemoteResult
import luca.carlino.loginauthapp.data.CredentialProvider
import javax.inject.Inject

class ProdAuthRemoteDatasource @Inject constructor(
    private val creds: CredentialProvider
) : AuthRemoteDatasource {


            override suspend fun login(email: String, password: String): AuthRemoteResult {
                delay(250)

                val emailOk = email == creds.expectedEmail()
                val passOk = password == creds.expectedPassword()

                return when {
                    !emailOk -> AuthRemoteResult.Error(AuthRemoteResult.Code.EMAIL_MISMATCH)
                    !passOk -> AuthRemoteResult.Error(AuthRemoteResult.Code.PASSWORD_INCORRECT)
                    else -> AuthRemoteResult.Ok
    }
}
}