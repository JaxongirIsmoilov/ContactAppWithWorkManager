package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import kotlinx.coroutines.flow.StateFlow
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface HomeScreenContract {

    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }

    data class UIState(val list: List<ContactParam> = emptyList())

    interface Intent {
        object ClickAddButton :Intent
        data class ClickDeleteButton(val id: String):Intent
        data class ClickEditButton(val data: ContactParam):Intent
        object UpdateData :Intent
    }


}