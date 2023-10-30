package uz.gita.jaxongir.contactappwithworkmanager.data.mappers

import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

fun ContactEntity.toParamData(): ContactParam =
    ContactParam(
        id, firstName, lastName, phone, state
    )


fun ContactParam.toEntity(): ContactEntity =
    ContactEntity(
        id, firstName, lastName, phone, state
    )