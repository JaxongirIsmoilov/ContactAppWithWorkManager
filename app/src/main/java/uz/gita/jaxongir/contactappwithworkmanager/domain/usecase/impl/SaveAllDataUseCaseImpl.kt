package uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl

import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.SaveAllDataUseCase
import javax.inject.Inject


class SaveAllDataUseCaseImpl @Inject constructor(
    private val repository: Repository
) : SaveAllDataUseCase {
    override fun invoke() = repository.saveAllData()
}