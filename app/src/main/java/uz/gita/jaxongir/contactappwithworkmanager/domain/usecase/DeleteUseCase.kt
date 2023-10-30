package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface DeleteUseCase {
    operator fun invoke(contactParam: ContactParam)
}