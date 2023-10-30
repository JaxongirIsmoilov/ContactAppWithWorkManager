package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.add

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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.jaxongir.contactappwithworkmanager.utils.MaskVisualTransformation

class AddScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: AddContract.ViewModel = getViewModel<AddViewModel>()
        AddScreenComponent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenComponent(
    uiState: State<AddContract.UIState>,
    onEventDispatcher: (AddContract.Intent) -> Unit
) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Add Screen",
            fontSize = 28.sp,
            color = Color.Cyan,
            modifier = Modifier.align(CenterHorizontally)
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it.trim()
            },
            placeholder = {
                Text(
                    text = "First Name",
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
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Cyan
            ),
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it.trim()
            },
            placeholder = {
                Text(
                    text = "Last Name",
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
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Cyan
            ),
        )

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it.trim()
            },
            placeholder = {
                Text(
                    text = "+998-##-###-##-##",
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
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Cyan
            ),
            visualTransformation = MaskVisualTransformation("+998-##-###-##-##")
        )

        OutlinedButton(
            onClick = { },
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "add")
        }


    }

}