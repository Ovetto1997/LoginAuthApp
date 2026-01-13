package luca.carlino.loginauthapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import luca.carlino.loginauthapp.data.db.AppDatabase

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) : AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "user.db" ).build()


}