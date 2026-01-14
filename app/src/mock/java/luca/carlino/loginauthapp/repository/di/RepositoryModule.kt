package luca.carlino.loginauthapp.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import luca.carlino.loginauthapp.data.AuthRemoteDatasource
import luca.carlino.loginauthapp.data.repository.AuthRepository
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.repository.MockRemoteDatasource
import luca.carlino.loginauthapp.repository.implementation.MockAuthRepository
import luca.carlino.loginauthapp.repository.implementation.MockUserRepository
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepo(impl: MockAuthRepository): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepo (impl: MockUserRepository): UserRepository

    @Binds @Singleton abstract fun bindAuthRemote(impl: MockRemoteDatasource): AuthRemoteDatasource



}