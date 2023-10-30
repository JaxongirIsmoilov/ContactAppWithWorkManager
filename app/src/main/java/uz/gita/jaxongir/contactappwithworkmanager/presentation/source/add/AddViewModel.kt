package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.AddUseCase
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val direction: AddDirection,
    private val addUseCase: AddUseCase
) : ViewModel(), AddContract.ViewModel {
    override val uiState = MutableStateFlow(AddContract.UIState())

    override fun onEventDispatcher(intent: AddContract.Intent) {
        when (intent) {
            is AddContract.Intent.ClickAddButton -> {
                viewModelScope.launch {
                    addUseCase.invoke(
                        ContactParam(
                            1,
                            intent.firstName,
                            intent.lastName,
                            intent.phone,
                            false
                        )
                    )

                    direction.back()

                }
            }
        }
    }

}