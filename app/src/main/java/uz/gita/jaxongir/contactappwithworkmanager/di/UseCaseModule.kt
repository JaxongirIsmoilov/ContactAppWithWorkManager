package uz.gita.jaxongir.contactappwithworkmanager.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.GetAllContactDataUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.impl.GetAllContactDataUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun bindGetAllContactDataUseCase(impl : GetAllContactDataUseCaseImpl) : GetAllContactDataUseCase

}