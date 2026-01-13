package luca.carlino.loginauthapp.data.repo.abstraction

import kotlinx.coroutines.flow.Flow
import luca.carlino.loginauthapp.domain.models.ProfileModel

interface UserRepository {
    fun observeProfile(): Flow<ProfileModel?>
    suspend fun saveProfile(userProfile: ProfileModel)
}