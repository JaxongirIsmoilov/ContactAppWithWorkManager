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

) : ViewModel(), HomeScreenContract.ViewModel {
    override val uiState = MutableStateFlow(HomeScreenContract.UIState())

    override fun onEventDispatcher(intent: HomeScreenContract.Intent) {
        when (intent) {
            HomeScreenContract.Intent.ClickAddButton -> {
                viewModelScope.launch {
                    direction.moveToAddScreen()
                }
            }

            HomeScreenContract.Intent.UpdateData -> {
                viewModelScope.launch {
                    getAllContactDataUseCase.invoke().onEach {list ->
                        reduce { it.copy(list =list ) }
                    }
                        .launchIn(viewModelScope)
                }
            }

            is HomeScreenContract.Intent.ClickEditButton -> {
                viewModelScope.launch {
                    direction.moveToEditScreen(intent.data)
                }
            }

            is HomeScreenContract.Intent.ClickDeleteButton -> {
                deleteUseCase.invoke(intent.data)
            }
        }
    }

    private fun reduce(block: (HomeScreenContract.UIState) -> HomeScreenContract.UIState) {
        val oldValue = uiState.value
        uiState.value = block(oldValue)
    }

}