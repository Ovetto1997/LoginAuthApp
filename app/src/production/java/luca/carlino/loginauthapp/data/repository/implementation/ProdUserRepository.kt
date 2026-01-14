package luca.carlino.loginauthapp.data.repository.implementation

import androidx.lifecycle.LiveData
import luca.carlino.loginauthapp.data.PreMadeProfile
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class ProdUserRepository @Inject constructor(
    private val store: PreMadeProfile
) : UserRepository {
    override fun observeProfile(): LiveData<ProfileModel?> = store.profile

    override suspend fun setProfile(userProfile: ProfileModel) = store.set(userProfile)

    override suspend fun clear() = store.clear()
}