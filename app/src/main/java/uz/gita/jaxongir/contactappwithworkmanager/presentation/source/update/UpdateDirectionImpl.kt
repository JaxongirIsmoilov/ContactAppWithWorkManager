package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import cafe.adriel.voyager.navigator.Navigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateDirectionImpl @Inject constructor(
    val appNavigator: Navigator
) : UpdateContract.EditDirection {
    override suspend fun backMainScreen() {
        appNavigator.pop()
    }
}