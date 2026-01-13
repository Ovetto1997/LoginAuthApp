package luca.carlino.loginauthapp.repository.implementation

import androidx.lifecycle.LiveData
import luca.carlino.loginauthapp.data.db.PreMadeProfile
import luca.carlino.loginauthapp.data.repo.abstraction.UserRepository
import luca.carlino.loginauthapp.domain.models.ProfileModel
import javax.inject.Inject

class MockUserRepository @Inject constructor(
    private val store: PreMadeProfile
): UserRepository {
    override fun observeProfile(): LiveData<ProfileModel?> {
        return store.profile
    }

    override suspend fun saveProfile(userProfile: ProfileModel) {
        return store.set(userProfile)
    }
}