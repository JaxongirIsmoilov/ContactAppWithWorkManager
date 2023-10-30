package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val direction: AddDirection

) : ViewModel(), AddContract.ViewModel {
    override val uiState = MutableStateFlow(AddContract.UIState())

    override fun onEventDispatcher(intent: AddContract.Intent) {
        when(intent){
            is AddContract.Intent.ClickAddButton -> {

            }
        }
    }

}