package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.setting

import android.content.Context
import kotlinx.coroutines.flow.StateFlow

interface SettingContract {

    interface ViewModel {

        val uiState : StateFlow<UiState>

        fun onEventDispatchers(intent : Intent)

    }

    data class UiState(
        val number : String = ""
    )

    interface Intent {

        data class ChangingNumber(
            val number : String
        ) : Intent

        data class ClickAddBtn(
            val context : Context
        ) : Intent
    }

}