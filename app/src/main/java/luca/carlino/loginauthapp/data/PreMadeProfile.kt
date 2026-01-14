package luca.carlino.loginauthapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class PreMadeProfile @Inject constructor() {
    private val _profile = MutableLiveData<ProfileModel?>(null)
    val profile: LiveData<ProfileModel?> = _profile

    fun set(value: ProfileModel) { _profile.value = value }
    fun clear() { _profile.value = null }

}