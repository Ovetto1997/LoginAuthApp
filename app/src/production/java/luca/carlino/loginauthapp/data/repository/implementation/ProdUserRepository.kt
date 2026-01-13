package luca.carlino.loginauthapp.data.repository.implementation

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import luca.carlino.loginauthapp.data.db.PreMadeProfile
import luca.carlino.loginauthapp.data.repo.abstraction.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class ProdUserRepository @Inject constructor(
    private val store : PreMadeProfile
) : UserRepository{
    override fun observeProfile(): LiveData<ProfileModel?> = store.profile

    override suspend fun saveProfile(userProfile: ProfileModel) = store.set(userProfile)

}