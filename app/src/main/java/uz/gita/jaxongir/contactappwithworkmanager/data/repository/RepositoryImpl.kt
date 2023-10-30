package uz.gita.jaxongir.contactappwithworkmanager.domain.repository.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toParamData
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dao: ContactDao) : Repository {
    private val scope = CoroutineScope(Dispatchers.IO + Job())

    override fun update(contactParam: ContactParam) {
        scope.launch {
            dao.update(contactParam.toEntity())
        }
    }

    override fun addContact(contactParam: ContactParam) {
        scope.launch {
            dao.addContact(contactParam.toEntity())
        }
    }

    override fun saveAllData() {

    }

    override fun getAllContactData(): Flow<List<ContactParam>> = flow{
        emit(dao.getAllContactData().map {
            it.toParamData()
        })
    }
        .flowOn(Dispatchers.IO)

    override  fun deleteContact(contactParam: ContactParam)  {
        scope.launch {
            dao.delete(contactParam.toEntity())
        }
    }
}