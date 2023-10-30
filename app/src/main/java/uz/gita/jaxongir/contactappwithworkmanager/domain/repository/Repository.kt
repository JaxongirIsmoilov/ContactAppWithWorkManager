package uz.gita.jaxongir.contactappwithworkmanager.domain.repository

import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface Repository {
    suspend fun update(contactParam: ContactParam)
     fun deleteContact(contactParam: ContactParam)
}