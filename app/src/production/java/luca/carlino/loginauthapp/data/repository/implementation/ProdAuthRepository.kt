package luca.carlino.loginauthapp.data.repository.implementation

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import luca.carlino.loginauthapp.R
import luca.carlino.loginauthapp.data.repo.abstraction.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import javax.inject.Inject

class ProdAuthRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthRepository {


        override suspend fun login(username: String, password: String): AuthResult {

            delay(200)

            val expectedU = context.getString(R.string.auth_expected_username)
            val expectedP = context.getString(R.string.auth_expected_password)

            val userOk = username == expectedU
            val passOk = password == expectedP

            return if (userOk && passOk) {
                AuthResult.Success
            } else {
                AuthResult.Failure(
                    usernameError = if (!userOk) "Username not recognized" else null,
                    passwordError = if (!passOk) "Incorrect password" else null
                )
            }

    }
}