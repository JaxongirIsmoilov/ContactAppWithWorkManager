package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface UpdateUseCase {
    operator fun invoke(contactParam: ContactParam)
}