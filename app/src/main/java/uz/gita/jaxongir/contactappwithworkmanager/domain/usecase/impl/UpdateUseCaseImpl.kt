package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.UpdateUseCase
import javax.inject.Inject

class UpdateUseCaseImpl @Inject constructor(private val repository: Repository) : UpdateUseCase {
    override suspend fun updateContact(contactParam: ContactParam) {
            repository.update(contactParam)
    }

}