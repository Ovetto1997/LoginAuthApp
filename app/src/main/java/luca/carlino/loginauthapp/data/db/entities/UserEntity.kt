package luca.carlino.loginauthapp.data.db.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users_auth", indices = [Index("id")])
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val nickName: String,
    val fullName: String,
    val age: Int,
    val avatarResName: String



)