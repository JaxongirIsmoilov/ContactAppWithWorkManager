package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.ui.theme.ContactAppWithWorkManagerTheme
import uz.gita.jaxongir.contactappwithworkmanager.utils.MaskVisualTransformation


class UpdateScreen(val contactParam: ContactParam) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: UpdateContract.EditViewModel = getViewModel<UpdateViewModel>()

        viewModel.onEventDispatcher(UpdateContract.Intent.ChangingName(contactParam.name))
        viewModel.onEventDispatcher(UpdateContract.Intent.ChangingPhone(contactParam.phone))

        UpdateScreenContent(
            contactParam,
            viewModel.uiState.collectAsState(),
            viewModel::onEventDispatcher
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreenContent(
    contactParam: ContactParam,
    uiState: State<UpdateContract.UiState>,
    onEventDispatcher: (UpdateContract.Intent) -> Unit
) {

    var phone by remember { mutableStateOf(contactParam.phone) }


    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Edit Screen",
            fontSize = 28.sp,
            color = Color.Cyan,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = uiState.value.name,
            onValueChange = {
                onEventDispatcher(UpdateContract.Intent.ChangingName(it))
            },
            placeholder = {
                Text(
                    text = contactParam.name,
                    style = TextStyle(
                        color = Color.LightGray,
                        fontWeight = FontWeight.W700
                    )
                )
            },
            modifier = Modifier
                .padding(top = 100.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .height(65.dp)
                .height(70.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 13,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Cyan,
                unfocusedBorderColor = Cyan
            )
        )

        OutlinedTextField(
            value = uiState.value.phone,
            onValueChange = {
                onEventDispatcher(UpdateContract.Intent.ChangingPhone(it))
            },
            placeholder = {
                Text(
                    text = contactParam.phone,
                    style = TextStyle(
                        color = Color.LightGray,
                        fontWeight = FontWeight.W700
                    )
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(65.dp)
                .height(70.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            maxLines = 13,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Cyan,
                unfocusedBorderColor = Cyan
            ),
            visualTransformation = MaskVisualTransformation("+998-##-###-##-##")
        )

        OutlinedButton(
            onClick = {
                onEventDispatcher.invoke(
                    UpdateContract.Intent.EditContact
                )
            },
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "update")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview() {
    ContactAppWithWorkManagerTheme {
        UpdateScreen(ContactParam(1, "sdfg", "491651894"))
    }
}