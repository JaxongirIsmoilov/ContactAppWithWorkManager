package uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getContactDao() : ContactDao

}