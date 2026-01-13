package luca.carlino.loginauthapp.data.repo.abstraction

import kotlinx.coroutines.flow.Flow
import luca.carlino.loginauthapp.domain.models.UserModel

interface UserRepository {
    fun observeProfile(): Flow<UserModel?>
    suspend fun saveProfile(userProfile: UserModel)
}