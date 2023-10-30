package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import kotlinx.coroutines.flow.StateFlow

interface HomeScreenContract {

    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }

    data class UIState(val list: List<ContactParam>)

    interface Intent {
        object ClickAddButton :Intent
        data class ClickDeleteButton(val id: String):Intent
        data class ClickEditButton(val data: ContactParam):Intent
        object UpdateData :Intent
    }


}