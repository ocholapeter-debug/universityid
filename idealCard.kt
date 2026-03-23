//ideal card

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

            Box(modifier = Modifier.fillMaxWidth()) {
                // Watermarks
                Image(
                    painter = logo,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp)
                        .alpha(0.05f),
                    contentScale = ContentScale.Fit
                )

                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Spacer(modifier = Modifier.width(20.dp))

                    // Right: Details
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "PENGERE DAVID ISRAEL",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF800000)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        DetailRow("Programme", "Bsc in Computer Science")
                        DetailRow("Reg Number", "24/1/306/D/674")

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Date of issue", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                                Text("01/02/2026", fontWeight = FontWeight.Bold)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Expiry Date", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                                Text("01/02/2029", fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        val barcode = painterResource(R.drawable.barcode2)
                        Image(
                            painter = barcode,
                            contentDescription = "bar code",
                            modifier = Modifier
                                .height(35.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }

            // Footer Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
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
