package luca.carlino.loginauthapp.data.repo.abstraction

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import luca.carlino.loginauthapp.domain.models.ProfileModel

interface UserRepository {
    fun observeProfile(): LiveData<ProfileModel?>
    suspend fun saveProfile(userProfile: ProfileModel)
}