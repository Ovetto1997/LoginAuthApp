package luca.carlino.loginauthapp.ui.presentation.home

import androidx.compose.ui.graphics.TransformOrigin
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import coil3.transform.Transformation
import dagger.hilt.android.lifecycle.HiltViewModel
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject



@HiltViewModel
class HomeViewModel @Inject constructor(
    repo: UserRepository
) : ViewModel(){

    private val source = repo.observeProfile()

    val ui = MediatorLiveData<HomeUiState>().apply {
        addSource(source) { p ->
            value = HomeUiState(
                nickname = p?.nickName ?: "Friend",
                avatarRes = p?.avatarResName ?: "avatar_cat"
            )
    }
    }
}

data class HomeUiState(
    val nickname: String,
    val avatarRes: String
)