package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.DeleteUseCase
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.GetAllContactDataUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val direction: HomeDirection,
    private val getAllContactDataUseCase: GetAllContactDataUseCase,
    private val deleteUseCase: DeleteUseCase

) : ViewModel(), HomeContract.ViewModel {
    override val uiState = MutableStateFlow(HomeContract.UIState())

    override fun onEventDispatcher(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.ClickAddButton -> {
                viewModelScope.launch {
                    direction.moveToAddScreen()
                }
            }

            HomeContract.Intent.UpdateData -> {
                viewModelScope.launch {
                    getAllContactDataUseCase.invoke().onEach {list ->
                        reduce { it.copy(list =list ) }
                    }
                        .launchIn(viewModelScope)
                }
            }

            is HomeContract.Intent.ClickEditButton -> {
                viewModelScope.launch {
                    direction.moveToEditScreen(intent.data)
                }
            }

            is HomeContract.Intent.ClickDeleteButton -> {
                deleteUseCase.invoke(intent.data)
            }
        }
    }

    private fun reduce(block: (HomeContract.UIState) -> HomeContract.UIState) {
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }

}