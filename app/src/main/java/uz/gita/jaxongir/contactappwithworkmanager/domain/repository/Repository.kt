package uz.gita.jaxongir.contactappwithworkmanager.domain.repository

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface Repository {
    fun update(contactParam: ContactParam)
}