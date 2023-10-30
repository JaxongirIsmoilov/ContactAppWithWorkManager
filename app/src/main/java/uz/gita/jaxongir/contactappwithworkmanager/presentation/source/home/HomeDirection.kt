package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add.AddScreen
import uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update.UpdateScreen
import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface HomeDirection {
    suspend fun moveToAddScreen()
    suspend fun moveToEditScreen(contactData: ContactParam)
}

@Singleton
class HomeDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : HomeDirection {
    override suspend fun moveToAddScreen() {
        appNavigator.navigateTo(AddScreen())
    }

    override suspend fun moveToEditScreen(contactData: ContactParam) {
        appNavigator.navigateTo(UpdateScreen(contactData))
    }

}