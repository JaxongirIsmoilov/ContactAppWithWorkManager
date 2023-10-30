package uz.gita.jaxongir.contactappwithworkmanager.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface Repository {
    suspend fun update(contactParam: ContactParam)
    fun saveAllData()
    fun getAllContactData() : Flow<List<ContactParam>>

}