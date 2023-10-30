package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.DeleteUseCase
import javax.inject.Inject

class DeleteUseCaseImpl @Inject constructor(
    private val repository: Repository
) : DeleteUseCase {
    override fun invoke(contactParam: ContactParam) {
        repository.deleteContact(contactParam)
    }
}
