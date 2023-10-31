package uz.gita.jaxongir.contactappwithworkmanager.presentation.source.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.jaxongir.contactappwithworkmanager.ui.workManager.ContactWorker
import java.util.concurrent.TimeUnit

class SettingScreen : AndroidScreen() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val context = LocalContext.current
        val oneTimeRequest = PeriodicWorkRequestBuilder<ContactWorker>(1L, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        val number = remember {
            mutableStateOf("")
        }

        Box (
            modifier = Modifier
                .fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .clip(RoundedCornerShape(12.dp))
            ){
                Text(text = "Enter time with minutes")
                TextField(
                    value = number.value,
                    onValueChange = {
                    number.value = it
                } ,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(onClick = {
                    val periodWorker = PeriodicWorkRequestBuilder<ContactWorker>(number.value.toLong(), TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build()
                    WorkManager.getInstance(context).enqueue(periodWorker)
                }) {

                }
            }
        }
    }
}