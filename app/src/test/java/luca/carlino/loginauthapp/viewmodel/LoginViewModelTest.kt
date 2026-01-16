package luca.carlino.loginauthapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.mockito.kotlin.whenever
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import luca.carlino.loginauthapp.data.repository.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import luca.carlino.loginauthapp.ui.presentation.login.LoginViewModel

import org.junit.After

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock

import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    private val testDispatcher = UnconfinedTestDispatcher()
    @Mock
    private lateinit var authRepository: AuthRepository
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)


        viewModel = LoginViewModel(authRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initial_Email_isEmptyString() {
        assertEquals("", viewModel.email.value)
    }

    @Test
    fun initial_Password_isEmptyString() {
        assertEquals("", viewModel.password.value)
    }
    @Test
    fun initial_emailError_isNull() {
        assertNull(viewModel.emailError.value)
    }

    @Test
    fun initial_passwordError_isNull() {
        assertNull(viewModel.passwordError.value)
    }

    @Test
    fun onLogicClicked_emptyMail_shows_Required_error() {
        viewModel.email.value = ""
        viewModel.password.value = "password123"

        viewModel.onLoginClicked()

        assertEquals("Required", viewModel.emailError.value)
        assertNull(viewModel.passwordError.value)
    }

    @Test
    fun onLogicClicked_emptyPassword_shows_Required_error() {

        viewModel.email.value = "test@example.com"
        viewModel.password.value = ""

        viewModel.onLoginClicked()

        assertNull(viewModel.emailError.value)
        assertEquals("Required", viewModel.passwordError.value)
    }

    @Test
    fun onLogicClicked_bothEmpty_shows_Required_error() {
        viewModel.email.value = ""
        viewModel.password.value = ""

        viewModel.onLoginClicked()

        assertEquals("Required", viewModel.emailError.value)
        assertEquals("Required", viewModel.passwordError.value)
    }
    @Test
    fun onLogicClicked_whiteSpaceOnlyEmail() {
        viewModel.email.value = ""
        viewModel.password.value = "password123"

        viewModel.onLoginClicked()

        assertEquals("Required", viewModel.emailError.value)

    }

    @Test
    fun onLogicClicked_Valid_goNextEvent() = runTest{
        viewModel.email.value = "test@example.com"
        viewModel.password.value = "password123"

        whenever(authRepository.login(org.mockito.kotlin.any(), org.mockito.kotlin.any())).thenReturn(AuthResult.Success)

        viewModel.onLoginClicked()

        val event = viewModel.goNext.getOrAwaitValue()

        assertNotNull(event.getContentIfNotHandled())

    }
    private fun <T> LiveData<T>.getOrAwaitValue(): T {
        var data: T? = null
        val observer = Observer<T> { data = it }
        this.observeForever(observer)
        this.removeObserver(observer)
        @Suppress("UNCHECKED_CAST")
        return data as T
    }

}