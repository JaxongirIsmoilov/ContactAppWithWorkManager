package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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

    private fun reduce(block: (UpdateContract.UiState) -> UpdateContract.UiState) {
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }

    override fun onEventDispatcher(intent: UpdateContract.Intent) {
        when (intent) {
            UpdateContract.Intent.Back -> {
                viewModelScope.launch { direction.backMainScreen() }
            }

            is UpdateContract.Intent.ChangingName -> {
                name = intent.name
                reduce { it.copy(name = intent.name) }
            }

            is UpdateContract.Intent.ChangingPhone -> {
                phone = intent.phone
                reduce { it.copy(phone = intent.phone) }
            }

            is UpdateContract.Intent.EditContact -> {
                viewModelScope.launch {
                }
            }
        }
    }
}