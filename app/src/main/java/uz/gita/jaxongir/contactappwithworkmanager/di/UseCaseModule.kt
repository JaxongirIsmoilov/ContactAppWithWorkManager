package uz.gita.jaxongir.contactappwithworkmanager.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.DeleteUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.AddUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.GetAllContactDataUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.SaveAllDataUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.UpdateUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.DeleteUseCaseImpl
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.AddContactUseCaseImpl
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.GetAllContactDataUseCaseImpl
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.SaveAllDataUseCaseImpl
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.UpdateUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun bindGetAllContactDataUseCase(impl : GetAllContactDataUseCaseImpl) : GetAllContactDataUseCase

    @[Binds Singleton]
    fun bindUpdateContactUseCase(impl: UpdateUseCaseImpl): UpdateUseCase

    @[Binds Singleton]
    fun bindDeleteContactUseCase(impl: DeleteUseCaseImpl): DeleteUseCase

    @[Binds Singleton]
    fun bindSaveAllDataUseCase(impl : SaveAllDataUseCaseImpl) : SaveAllDataUseCase

    @[Binds Singleton]
    fun bindsAddUseCase(impl : AddContactUseCaseImpl) : AddUseCase

}