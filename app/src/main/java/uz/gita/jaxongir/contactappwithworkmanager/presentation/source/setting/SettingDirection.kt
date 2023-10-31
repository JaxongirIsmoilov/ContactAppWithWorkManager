package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.setting

import uz.gita.jaxongir.contactappwithworkmanager.ui.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SettingDirection {

    suspend fun back()

}

@Singleton
class SettingDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SettingDirection{
    override suspend fun back() {
        appNavigator.back()
    }
}