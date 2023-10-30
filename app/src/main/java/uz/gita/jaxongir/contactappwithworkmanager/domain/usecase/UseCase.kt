package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface UpdateUseCase {
    suspend fun updateContact(contactParam: ContactParam)
}