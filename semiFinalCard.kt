//semi final card

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            shape = RoundedCornerShape(15.dp), // Correct placement for RectangleShape
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
                        .size(height = 130.dp, width = 100.dp)  // taller than wide → fits header
                        .offset(y = (30).dp)               // push left so half is outside
                        .clip(CircleShape)
                        .border( width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        )
                        .background(Color.White)
                )

                // Left: Profile Photo
                Image(
                    painter = profile,
                    contentDescription = "profile photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(height = 130.dp, width = 100.dp)  // taller than wide → fits header
                        .offset(y = (50).dp)               // push left so half is outside
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

            Spacer(modifier = Modifier.width(40.dp))

            Box {
                // Left Watermark
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
                Spacer(modifier = Modifier.width(100.dp))
                // Right Watermark
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
                    modifier = Modifier.padding(all = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(

                        modifier = Modifier
                            .fillMaxWidth(1F)
                            .background(
                                color = Color(0xFFFFFFFF)
                            )

                    ) {


                    }


                    Spacer(modifier = Modifier.height(40.dp))


                    Row {
                        Text(
                            text = "PENGERE DAVID ISRAEL"

                        )
                    }
                    Row  {
                        Text(
                            text = " Programme:"
                        )
                        Text(
                            text = " Bsc in Computer Science"
                        )
                    }
                    Row {
                        Text(
                            text = " Registraton Number:"
                        )
                        Text(
                            text = " 24/1/306/D/674"
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start)) {
                        Row(Modifier.weight(1f)) {
                            Text("Date of issue: ", fontWeight = FontWeight.Medium)
                            Text("01/02/2026")
                        }
                        Row(Modifier.weight(1f)) {
                            Text("Expiry Date: ", fontWeight = FontWeight.Medium)
                            Text("01/02/2029")
                        }
                    }

                    val barcode = painterResource(R.drawable.barcode2)
                    Image(
                        painter = barcode,
                        contentDescription = "bar code",

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


@Composable
fun DetailRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 1.dp)) {
        Text(text = "$label: ", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun GreetingPreview() {
    UniversityIdTheme {
        StudentsId()
    }
}
