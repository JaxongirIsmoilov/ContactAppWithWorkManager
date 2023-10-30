package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.GetAllContactDataUseCase
import javax.inject.Inject

class GetAllContactDataUseCaseImpl @Inject constructor(
    private val repository: Repository
): GetAllContactDataUseCase {
    override fun invoke(): Flow<List<ContactParam>> = repository.getAllContactData()
}