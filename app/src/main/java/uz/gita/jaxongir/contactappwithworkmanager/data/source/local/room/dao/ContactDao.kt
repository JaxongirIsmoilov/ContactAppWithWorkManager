package uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContact(contactEntity: ContactEntity)

    @Update
    fun update(contactEntity: ContactEntity)

    @Query("select * from contacts")
    fun getAllContactData(): List<ContactEntity>


    @Delete
    fun delete(contactEntity: ContactEntity)
}