//final piece

package ug.com.universityid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ug.com.universityid.ui.theme.UniversityIdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityIdTheme {
                StudentsId()
            }
        }
    }
}

@Composable
fun StudentsId() {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            val flag = painterResource(R.drawable.flag)
            val logo = painterResource(R.drawable.logo2)
            val profile = painterResource(R.drawable.prof)

            // Header Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color(0xFF800000))
                    .padding(horizontal = 12.dp)
            ) {
                Image(
                    painter = logo,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(height = 130.dp, width = 100.dp)
                        .offset(y = (30).dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        )
                        .background(Color.White)
                )

                // Profile Photo
                Image(
                    painter = profile,
                    contentDescription = "profile photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(height = 130.dp, width = 100.dp)
                        .offset(y = (50).dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF800000),
                            shape = CircleShape
                        )
                )

                Image(
                    painter = flag,
                    contentDescription = null,
                    modifier = Modifier
                        .size(height = 130.dp, width = 100.dp)
                        .align(Alignment.CenterEnd)
                )
            }

           // Spacer(modifier = Modifier.height(0.dp))

            Box {
                // Watermarks
                Image(
                    painter = logo,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(200.dp)
                        .offset(x = (-80).dp)
                        .alpha(0.1f),
                   contentScale = ContentScale.Fit
                )

                Image(
                    painter = logo,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(200.dp)
                        .offset(x = (50).dp)
                        .alpha(0.1f),
                   contentScale = ContentScale.Fit
                )

                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(50.dp))

                    Text(text = stringResource(R.string.name), fontWeight = FontWeight.Bold)

                    Row  {
                        Text(text = stringResource(R.string.programme))
                        Text(text = stringResource(R.string.programe_name))
                    }
                    Row {
                        Text(text = stringResource(R.string.registraton_number))
                        Text(text = stringResource(R.string.reg_no))
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start)) {
                       Row(Modifier.weight(1f)) {
                            Text(stringResource(R.string.date_of_issue), fontWeight = FontWeight.Medium)
                            Text(stringResource(R.string.issue_date))
                        }
                        Row(Modifier.weight(1f)) {
                            Text(stringResource(R.string.expiry_date), fontWeight = FontWeight.Medium)
                            Text(stringResource(R.string.date_of_expiry))
                        }
                    }

                    val barcode = painterResource(R.drawable.barcode2)
                    Image(
                        painter = barcode,
                        contentDescription = "bar code",
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            //.fillMaxWidth(1f)
                            //.size(height = 100.dp, width = 300.dp)
                           // .width(300.dp)
                            //.scale(1f)
                            .graphicsLayer { scaleX = 2f }

                    )
                }
            }
            
            // Footer Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(color = Color(0xFF800000))
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun GreetingPreview() {
    UniversityIdTheme {
        StudentsId()
    }
}


/*
<resources>
    <string name="app_name">UniversityId</string>
    <string name="name">PENGERE DAVID ISRAEL</string>
    <string name="programme">" Programme:"</string>
    <string name="programe_name">" Bsc in Computer Science"</string>
    <string name="registraton_number">" Registraton Number:"</string>
    <string name="reg_no">" 24/1/306/D/674"</string>
    <string name="expiry_date">"Expiry Date: "</string>
    <string name="date_of_expiry">01/02/2029</string>
    <string name="date_of_issue">"Date of issue: "</string>
    <string name="issue_date">01/02/2026</string>
</resources>
*/