package uz.gita.jaxongir.contactappwithworkmanager.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home.HomeDirection
import uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home.HomeDirectionImpl

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {


    @Binds
    fun bindsHomeScreenDirection(impl: HomeDirectionImpl): HomeDirection
}