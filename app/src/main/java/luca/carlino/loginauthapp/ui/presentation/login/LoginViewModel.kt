package luca.carlino.loginauthapp.ui.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import luca.carlino.loginauthapp.data.repository.AuthRepository
import luca.carlino.loginauthapp.domain.models.AuthResult
import luca.carlino.loginauthapp.domain.util.Event
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val email = MutableLiveData("")
    val password = MutableLiveData("")


    val emailError = MutableLiveData<String?>(null)
    val passwordError = MutableLiveData<String?>(null)


    private val _snackBar = MutableLiveData<Event<String>>()
    val snackBar: LiveData<Event<String>> = _snackBar


    private val _goNext = MutableLiveData<Event<Unit>>()
    val goNext: LiveData<Event<Unit>> = _goNext


    fun onLoginClicked() {
        emailError.value = null
        passwordError.value = null

        val e = email.value.orEmpty().trim()
        val p = password.value.orEmpty()


        if (e.isBlank()) emailError.value = "Required"
        if (p.isBlank()) passwordError.value = "Required"
        if (emailError.value != null || passwordError.value != null) return

        viewModelScope.launch {
            when (val r = authRepository.login(e, p)) {
                is AuthResult.Success -> _goNext.value = Event(Unit)
                is AuthResult.Failure -> {
                    emailError.value = r.emailError
                    passwordError.value = r.passwordError

                    val msg = listOfNotNull(r.emailError, r.passwordError).joinToString(" • ")
                    if (msg.isNotBlank()) _snackBar.value = Event(msg)
                }

            }
        }

    }
}