package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingViewModelImpl(

) : SettingContract.ViewModel , ViewModel() {

    var number = ""

    override val uiState = MutableStateFlow<SettingContract.UiState>(SettingContract.UiState())

    override fun onEventDispatchers(intent: SettingContract.Intent) {

        when(intent) {

            is SettingContract.Intent.ChangingNumber -> {
                reduce { it.copy(number = intent.number) }
            }

            is SettingContract.Intent.ClickAddBtn -> {

            }

        }

    }

    private fun reduce(block : (SettingContract.UiState) -> SettingContract.UiState) {
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }

}