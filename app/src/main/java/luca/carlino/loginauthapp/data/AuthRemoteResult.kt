package luca.carlino.loginauthapp.data

sealed class AuthRemoteResult {
    data object Ok: AuthRemoteResult()
    data class Error(val code: Code): AuthRemoteResult()
    enum class Code { EMAIL_MISMATCH, PASSWORD_INCORRECT }
}