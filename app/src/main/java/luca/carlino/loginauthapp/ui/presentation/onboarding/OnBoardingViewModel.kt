package luca.carlino.loginauthapp.ui.presentation.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import luca.carlino.loginauthapp.domain.util.Event
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel(){
    val nickName = MutableLiveData("")
    val fullName = MutableLiveData("")
    val age = MutableLiveData(18)
    val avatarResName = MutableLiveData("avatar")


    private val _goHome = MutableLiveData<Event<Unit>>()
    val goHome: LiveData<Event<Unit>> = _goHome

    fun selectAvatar(resName: String) {
        avatarResName.value = resName
    }

    fun onFinish() {
        val profile = ProfileModel(
            nickName = nickName.value.orEmpty().trim().ifBlank { "Friend" },
            fullName = fullName.value.orEmpty().trim().ifBlank { "Anonymous" },
            age = (age.value ?: 19).coerceIn(1, 120),
            avatarResName = avatarResName.value.orEmpty().ifBlank { "avatar" }
        )

        viewModelScope.launch {
            userRepository.setProfile(profile)
            _goHome.value = Event(Unit)
        }
    }

}