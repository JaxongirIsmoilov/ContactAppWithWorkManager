package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.jaxongir.contactappwithworkmanager.R
import uz.gita.jaxongir.contactappwithworkmanager.presentation.source.update.UpdateContract
import uz.gita.jaxongir.contactappwithworkmanager.ui.components.Contact_item

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<HomeViewModel>()
        viewModel.onEventDispatcher(HomeContract.Intent.UpdateData)
        HomeScreenContent(viewModel.uiState.collectAsState(), viewModel::onEventDispatcher)
    }
}

@Composable
fun HomeScreenContent(
    uiState: State<HomeContract.UIState>,
    onEventDispatcher : (HomeContract.Intent) -> Unit
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
                    .padding(end = 10.dp) ,
                colorFilter = ColorFilter.tint(Color.White)
            )

        }



        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 57.dp)
        ) {
                item {
                    Spacer(modifier = Modifier.size(15.dp))
                }
                items(uiState.value.list) {
                    Contact_item(
                        contactParam = it,
                        longDeleteClick = {
                            onEventDispatcher.invoke(
                                HomeContract.Intent.ClickDeleteButton(it)
                            )
                        },
                        clickUpdate = {
                            onEventDispatcher.invoke(
                                HomeContract.Intent.ClickEditButton(it)
                            )
                        })
                    Spacer(modifier = Modifier.size(15.dp))
                }
        }

        Box (
            modifier = Modifier
                .padding(16.dp)
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Cyan)
                .align(Alignment.BottomEnd)
                .clickable {
                    onEventDispatcher(HomeContract.Intent.ClickAddButton)
                }
        ){
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription =  ""
            )
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(mutableStateOf(HomeContract.UIState())){}
}