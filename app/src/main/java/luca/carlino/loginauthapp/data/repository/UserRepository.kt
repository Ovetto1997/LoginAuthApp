package luca.carlino.loginauthapp.data.repository

import androidx.lifecycle.LiveData
import luca.carlino.loginauthapp.domain.models.ProfileModel

interface UserRepository {
    fun observeProfile(): LiveData<ProfileModel?>
    suspend fun setProfile(userProfile: ProfileModel)
    suspend fun clear()
}