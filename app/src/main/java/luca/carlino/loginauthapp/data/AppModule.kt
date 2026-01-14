package luca.carlino.loginauthapp.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import luca.carlino.loginauthapp.R
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCredentialsProvider(@ApplicationContext ctx: Context): CredentialProvider =
        object : CredentialProvider {
            override fun expectedEmail(): String = ctx.getString(R.string.expected_email)
            override fun expectedPassword(): String = ctx.getString(R.string.expected_password)
        }
}