package uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "first_name")
    val firstName : String,
    @ColumnInfo("last_name")
    val lastName: String,
    val phone: String,
    val state : Boolean
)