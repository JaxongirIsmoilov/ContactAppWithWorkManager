package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add

import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface AddDirection {
    suspend fun back()
}

@Singleton
class AddDirectionImpl @Inject constructor(private val appNavigator: AppNavigator) : AddDirection{
    override suspend fun back() {
        appNavigator.back()
    }

}