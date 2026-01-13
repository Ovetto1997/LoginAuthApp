package luca.carlino.loginauthapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import luca.carlino.loginauthapp.data.db.dao.UserDao
import luca.carlino.loginauthapp.data.db.entities.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null
//da chiedere domani se va fatto qui o nel module
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }


    }
}