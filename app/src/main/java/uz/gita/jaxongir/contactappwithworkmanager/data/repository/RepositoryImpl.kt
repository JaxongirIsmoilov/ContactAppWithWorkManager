package uz.gita.jaxongir.contactappwithworkmanager.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toContactRequest
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toParamData
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.entity.ContactEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.source.remote.api.ContactApi
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: ContactDao ,
    private val contactApi: ContactApi
) : Repository {
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
        scope.launch {
            dao.getAllContactData().filter { !it.state }.forEach {
                val response = contactApi.addContact(it.toContactRequest())
                if (response.isSuccessful && response.body() != null) {
                    dao.update(
                        ContactEntity(
                            it.id ,
                            it.firstName ,
                            it.lastName,
                            it.phone ,
                            true
                        )
                    )
                }
            }
        }
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