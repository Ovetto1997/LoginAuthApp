import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import luca.carlino.loginauthapp.data.db.AppDatabase
import luca.carlino.loginauthapp.data.db.dao.UserDao

/*
* chiedere
* se a senso farlo
* */
@Module
@InstallIn(SingletonComponent::class)
object UserDaoModule {

    @Provides
    fun provideUserDao(
        database: AppDatabase
    ): UserDao{
        return database.userDao()
    }

}