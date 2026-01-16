package luca.carlino.loginauthapp.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import luca.carlino.loginauthapp.data.AuthRemoteDatasource
import luca.carlino.loginauthapp.data.repository.AuthRepository
import luca.carlino.loginauthapp.data.repository.UserRepository
import luca.carlino.loginauthapp.data.datasource.ProdAuthRemoteDatasource
import luca.carlino.loginauthapp.data.repository.implementation.ProdAuthRepository
import luca.carlino.loginauthapp.data.repository.implementation.ProdUserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds @Singleton abstract fun bindAuthRepo(impl: ProdAuthRepository): AuthRepository
    @Binds @Singleton abstract fun bindUserRepo(impl: ProdUserRepository): UserRepository
    @Binds @Singleton abstract fun bindAuthRemote(impl: ProdAuthRemoteDatasource): AuthRemoteDatasource
}