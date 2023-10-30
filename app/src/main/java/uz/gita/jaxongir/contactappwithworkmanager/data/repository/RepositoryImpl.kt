package uz.gita.jaxongir.contactappwithworkmanager.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dao: ContactDao) : Repository {
    override suspend fun update(contactParam: ContactParam) {
        withContext(Dispatchers.IO) {
            dao.update(contactParam.toEntity())
        }
    }
}