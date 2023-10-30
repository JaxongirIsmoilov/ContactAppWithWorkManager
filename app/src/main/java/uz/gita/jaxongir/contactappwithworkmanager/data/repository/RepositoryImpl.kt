package uz.gita.jaxongir.contactappwithworkmanager.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dao: ContactDao) : Repository {

    private val scope = CoroutineScope(Dispatchers.IO + Job())
    override suspend fun update(contactParam: ContactParam) {
        withContext(Dispatchers.IO) {
            dao.update(contactParam.toEntity())
        }
    }

    override  fun deleteContact(contactParam: ContactParam)  {
        scope.launch {
            dao.delete(contactParam.toEntity())
        }
    }
}