package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val direction: HomeDirection,

): ViewModel(), HomeScreenContract.ViewModel {
    override val uiState =  MutableStateFlow(HomeScreenContract.UIState())

    override fun onEventDispatcher(intent: HomeScreenContract.Intent) {
        when(intent){
            HomeScreenContract.Intent.ClickAddButton -> {

            }

            HomeScreenContract.Intent.UpdateData -> {

            }

            is HomeScreenContract.Intent.ClickEditButton -> {

            }

            is HomeScreenContract.Intent.ClickDeleteButton -> {

            }
        }
    }

}