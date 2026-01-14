package luca.carlino.loginauthapp.repository.implementation

import androidx.lifecycle.LiveData
import luca.carlino.loginauthapp.data.PreMadeProfile
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class MockUserRepository @Inject constructor(
    private val store: PreMadeProfile
): UserRepository {
    override fun observeProfile(): LiveData<ProfileModel?> {
        return store.profile
    }

    override suspend fun setProfile(userProfile: ProfileModel) {
        return store.set(userProfile)
    }

    override suspend fun clear() {
        store.clear()
    }
}