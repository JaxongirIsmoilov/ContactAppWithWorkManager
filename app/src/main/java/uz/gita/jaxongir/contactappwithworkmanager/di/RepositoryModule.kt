package uz.gita.jaxongir.contactappwithworkmanager.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.Repository
import uz.gita.jaxongir.contactappwithworkmanager.domain.repository.impl.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindRepository(impl : RepositoryImpl) : Repository

}