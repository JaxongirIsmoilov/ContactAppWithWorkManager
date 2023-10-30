package uz.gita.jaxongir.contactappwithworkmanager.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.jaxongir.contactappwithworkmanager.R
import uz.gita.jaxongir.contactappwithworkmanager.ui.theme.ContactAppWithWorkManagerTheme

@Composable
fun Contact_item() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Cyan, //Card background color
//                contentColor = Color.White  //Card content color,e.g.text
        )
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(40.dp)
            )

            Text(
                text = "User",
                fontSize = 18.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 45.dp, top = 5.dp)
            )

            Text(
                text = "+998999977798",
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 45.dp, bottom = 5.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_check_24),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
                    .size(20.dp)
            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun Contact_item_preview() {
    ContactAppWithWorkManagerTheme {

        Contact_item()

    }
}