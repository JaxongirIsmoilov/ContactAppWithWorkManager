package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.UpdateUseCase
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val updateUseCase: UpdateUseCase,
    private val direction: UpdateDirectionImpl
) : UpdateContract.EditViewModel, ViewModel() {

    override val uiState = MutableStateFlow(UpdateContract.UiState())
    override var sideEffect: (UpdateContract.SideEffect) -> Unit = {}
    private var name = ""
    private var phone = ""
    private var lastName = ""
    private lateinit var contactParam: ContactParam

    private fun reduce(block: (UpdateContract.UiState) -> UpdateContract.UiState) {
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }

    override fun onEventDispatcher(intent: UpdateContract.Intent) {
        when (intent) {
            UpdateContract.Intent.Back -> {
                viewModelScope.launch { direction.backMainScreen() }
            }

            is UpdateContract.Intent.ChangingLastName -> {
                lastName = intent.lastName
                reduce { it.copy(lastName = lastName) }
            }

            is UpdateContract.Intent.PutOldData -> {
                contactParam = intent.contactParam
                name = contactParam.firstName
                lastName = contactParam.lastName
                phone = contactParam.phone
                reduce { it.copy(
                    firstName = name ,
                    lastName = lastName ,
                    phone = phone
                ) }
            }

            is UpdateContract.Intent.ChangingName -> {
                name = intent.name
                reduce { it.copy(firstName = intent.name) }
            }

            is UpdateContract.Intent.ChangingPhone -> {
                phone = intent.phone
                reduce { it.copy(phone = intent.phone) }
            }

            is UpdateContract.Intent.EditContact -> {
                viewModelScope.launch {
                    updateUseCase(
                        ContactParam(
                            contactParam.id ,
                            name ,
                            lastName,
                            phone ,
                            false
                        )
                    )
                }
                viewModelScope.launch { direction.backMainScreen() }
            }
        }
    }
}