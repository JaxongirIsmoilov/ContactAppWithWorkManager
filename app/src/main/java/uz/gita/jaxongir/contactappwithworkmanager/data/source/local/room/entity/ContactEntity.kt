package uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: String
)