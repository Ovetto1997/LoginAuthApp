package luca.carlino.loginauthapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import luca.carlino.loginauthapp.data.db.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users_auth WHERE id = 1")
    fun observeUser(): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: UserEntity)
}