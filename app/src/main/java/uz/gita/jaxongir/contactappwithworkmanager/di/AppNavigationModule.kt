package uz.gita.jaxongir.contactappwithworkmanager.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.AppNavigator
import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.NavigationDispatcher
import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.NavigationHandler
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppNavigationModule {

    @[Binds Singleton]
    fun bindAppNavigator(impl : NavigationDispatcher) : AppNavigator

    @[Binds Singleton]
    fun bindNavigationHandler(impl : NavigationDispatcher) : NavigationHandler

}