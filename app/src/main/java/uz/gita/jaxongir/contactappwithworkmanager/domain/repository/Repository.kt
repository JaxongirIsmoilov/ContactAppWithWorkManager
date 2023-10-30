package uz.gita.jaxongir.contactappwithworkmanager.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface Repository {
    fun update(contactParam: ContactParam)
    fun addContact(contactParam: ContactParam)
    fun saveAllData()
    fun getAllContactData() : Flow<List<ContactParam>>

     fun deleteContact(contactParam: ContactParam)
}