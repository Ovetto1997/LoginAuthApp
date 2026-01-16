package luca.carlino.loginauthapp.data.repository

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import luca.carlino.loginauthapp.data.AuthRemoteDatasource
import luca.carlino.loginauthapp.data.AuthRemoteResult
import luca.carlino.loginauthapp.data.repository.implementation.ProdAuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class ProdAuthRepositoryTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var remoteDatasource: AuthRemoteDatasource

    private lateinit var repository: ProdAuthRepository

    @Before
    fun setUp() {
        repository = ProdAuthRepository(remoteDatasource)
    }

    @Test
    fun loginReturnSuccess_when_remote_returns_Ok() = runTest{

        whenever(remoteDatasource.login(any(), any()))
            .thenReturn(AuthRemoteResult.Ok)

        val result = repository.login("test@example", "password123")

        assertEquals(AuthResult.Success, result)

    }


    @Test
    fun loginReturnFailure_when_remote_returns_EMAIL_MISMATCH() = runTest {
        whenever(remoteDatasource.login(any(),any()))
            .thenReturn(AuthRemoteResult.Error(AuthRemoteResult.Code.EMAIL_MISMATCH))

        val result = repository.login("wrong@example.com", "password123")

        assertTrue(result is AuthResult.Failure)
        val failure = result as AuthResult.Failure
        assertEquals("Email mismatch", failure.emailError)
        assertNull(failure.passwordError)
    }

    @Test
    fun loginReturnFailure_when_remote_returns_PASSWORD_INCORRECT() = runTest {
        whenever(remoteDatasource.login(any(), any()))
            .thenReturn(AuthRemoteResult. Error(AuthRemoteResult.Code.PASSWORD_INCORRECT))


        val result = repository.login("test@example.com", "wrongpassword")


        assertTrue(result is AuthResult. Failure)
        val failure = result as AuthResult.Failure
        assertEquals("Incorrect password", failure. passwordError)
        assertEquals("", failure.emailError)
    }




}