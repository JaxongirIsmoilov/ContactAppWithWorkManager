package uz.gita.jaxongir.contactappwithworkmanager.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toEntity
import uz.gita.jaxongir.contactappwithworkmanager.data.mappers.toParamData
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: ContactDao
) : Repository {
    override suspend fun update(contactParam: ContactParam) {
        withContext(Dispatchers.IO) {
            dao.update(contactParam.toEntity())
        }
    }

    override fun saveAllData() {

    }

    override fun getAllContactData(): Flow<List<ContactParam>> = callbackFlow{
        trySend(
            dao.getAllContactData().map {
                it.toParamData()
            }
        )
    }
}