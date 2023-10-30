package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add

import kotlinx.coroutines.flow.StateFlow

interface AddContract {

    interface ViewModel{
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(val isEnabled : Boolean = true)

    interface Intent {
        data class ClickAddButton(val firstName : String, val lastName : String, val phone : String) : Intent
    }
}