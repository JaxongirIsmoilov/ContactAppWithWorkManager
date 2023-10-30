package uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Update
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity

@Dao
interface ContactDao {
    @Update
    fun update(contactEntity: ContactEntity)
}