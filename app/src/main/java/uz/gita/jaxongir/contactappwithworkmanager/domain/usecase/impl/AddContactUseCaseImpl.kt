package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.AddUseCase
import javax.inject.Inject

class AddContactUseCaseImpl @Inject constructor(
    private val repository: Repository
) : AddUseCase {
    override fun invoke(contactParam: ContactParam) {
        repository.addContact(contactParam)
    }
}