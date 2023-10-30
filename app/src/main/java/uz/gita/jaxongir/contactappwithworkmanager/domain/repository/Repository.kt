package uz.gita.jaxongir.contactappwithworkmanager.domain.repository

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface Repository {
    suspend fun update(contactParam: ContactParam)
}