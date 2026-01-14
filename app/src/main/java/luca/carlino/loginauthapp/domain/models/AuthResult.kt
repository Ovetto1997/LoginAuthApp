package luca.carlino.loginauthapp.domain.models

sealed class AuthResult {
    data object Success : AuthResult()
    data class Failure(
        val passwordError: String? = null,
        val emailError: String? = null
    ) : AuthResult()

}

