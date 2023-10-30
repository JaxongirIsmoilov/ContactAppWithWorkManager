package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface GetAllContactDataUseCase {

    operator fun invoke() : Flow<List<ContactParam>>

}