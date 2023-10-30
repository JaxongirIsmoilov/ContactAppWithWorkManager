package uz.gita.jaxongir.contactappwithworkmanager.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import uz.gita.jaxongir.contactappwithworkmanager.domain.params.ContactParam
import uz.gita.jaxongir.contactappwithworkmanager.ui.theme.ContactAppWithWorkManagerTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Contact_item(
    contactParam: ContactParam,
    longDeleteClick: (ContactParam) -> Unit,
    clickUpdate: (ContactParam) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .combinedClickable(
                onClick = { clickUpdate.invoke(contactParam) },
                onLongClick = { longDeleteClick.invoke(contactParam) }),
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

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 45.dp, top = 5.dp)
            ) {

                Text(
                    text = contactParam.firstName,
                    fontSize = 18.sp,

                    )
                Text(
                    text = contactParam.lastName,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }



            Text(
                text = contactParam.phone,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 45.dp, bottom = 5.dp)
            )

            Image(
                painter = painterResource(
                    id = if (contactParam.state) {
                        R.drawable.baseline_check_24
                    } else {
                        R.drawable.baseline_access_time_24
                    }
                ),
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

        Contact_item(ContactParam(1, "", "", "", false), {}, {})

    }
}