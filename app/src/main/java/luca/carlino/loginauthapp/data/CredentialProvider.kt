package luca.carlino.loginauthapp.data

interface CredentialProvider {
    fun expectedEmail(): String
    fun expectedPassword(): String
}