package luca.carlino.loginauthapp.repository

import android.content.Context
import androidx.activity.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import luca.carlino.loginauthapp.data.repo.abstraction.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import javax.inject.Inject

class MockAuthRepository @Inject constructor(
    @ApplicationContext private val context: Context
): AuthRepository {

    override suspend fun login(username: String, password: String): AuthResult {
        delay(250)
        val demoPass = context.getString(luca.carlino.loginauthapp.R.string.auth_expected_password)


        val allowedUsers = setOf(
            context.getString(luca.carlino.loginauthapp.R.string.auth_expected_username),
            "test",
            "qa"
        )

        val userOk = username in allowedUsers
        val passwordOk = password == demoPass
        return if (userOk && passwordOk) AuthResult.Success
        else AuthResult.Failure(
            usernameError = if (!userOk) "Mock: user not in allowlist" else null,
            passwordError = if (!passwordOk) "Mock: wrong password" else null
        )
    }
}