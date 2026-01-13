package luca.carlino.loginauthapp.domain.models

sealed class AuthResult {
    data object Success : AuthResult()
    data class Failure(
        val usernameError: String? = null,
        val passwordError: String? = null
    ) : AuthResult()

}

