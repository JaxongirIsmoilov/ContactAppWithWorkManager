package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import cafe.adriel.voyager.navigator.Navigator
import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface UpdateDirection {
    suspend fun backMainScreen()
}

@Singleton
class UpdateDirectionImpl @Inject constructor(
    val appNavigator: AppNavigator
) : UpdateDirection {
    override suspend fun backMainScreen() {
        appNavigator.back()
    }
}