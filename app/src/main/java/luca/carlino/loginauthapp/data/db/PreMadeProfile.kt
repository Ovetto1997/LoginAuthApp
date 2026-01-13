package luca.carlino.loginauthapp.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class PreMadeProfile @Inject constructor() {
    private val _profile = MutableLiveData<ProfileModel?>(null)
    val profile: LiveData<ProfileModel?> = _profile

    fun set(profileModel: ProfileModel) { _profile.value = profileModel}
    fun clear() {_profile.value = null}
}