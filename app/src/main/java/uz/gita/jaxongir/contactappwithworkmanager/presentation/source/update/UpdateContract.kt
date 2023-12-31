package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import kotlinx.coroutines.flow.StateFlow
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam

interface UpdateContract {

    interface EditViewModel {
        val uiState: StateFlow<UiState>
        var sideEffect: (SideEffect) -> Unit
        fun onEventDispatcher(intent: Intent)
    }

    data class UiState(
        val isSuccess: Boolean = false,
        val firstName: String = "",
        val lastName : String = "" ,
        val phone: String = "",
        var contactData: List<ContactParam> = emptyList()
    )

    interface Intent {
        object Back : Intent
        object EditContact : Intent

        data class PutOldData(
            val contactParam: ContactParam
        ) : Intent
        data class ChangingName(
            val name: String
        ) : Intent

        data class ChangingLastName(
            val lastName: String
        ) : Intent

        data class ChangingPhone(
            val phone: String
        ) : Intent

    }

    interface SideEffect {
        data class Toast(
            val message: String
        ) : SideEffect
    }


}