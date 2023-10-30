package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.jaxongir.contactappwithworkmanager.R
import uz.gita.jaxongir.contactappwithworkmanager.ui.components.Contact_item

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<HomeViewModel>()
        HomeScreenContent(viewModel.uiState.collectAsState(), viewModel::onEventDispatcher)
    }
}

@Composable
fun HomeScreenContent(
    uiState: State<HomeScreenContract.UIState>,
    onEventDispatcher : (HomeScreenContract.Intent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Cyan)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "Contacts",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 24.sp,
                color = Color(0xFFFFFFFF)
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
            )

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 57.dp)
        ) {
                items(uiState.value.list){
                    Contact_item(contactParam = it, longDeleteClick = {onEventDispatcher.invoke(HomeScreenContract.Intent.ClickDeleteButton(it))}, clickUpdate = {onEventDispatcher.invoke(HomeScreenContract.Intent.ClickEditButton(it))})
                }
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(mutableStateOf(HomeScreenContract.UIState())){}
}