package com.example.aroundegypt.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aroundegypt.R
import com.example.aroundegypt.ui.theme.IconColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceBottomSheet(
    sheetState: SheetState,
    isOpen : Boolean,
    onDismissRequest : () -> Unit,
) {
    var isLoved by rememberSaveable { mutableStateOf(false) }

    if (isOpen) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxSize(),
            sheetState = sheetState,
            onDismissRequest = onDismissRequest,
            dragHandle = null,
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample_img),
                        contentDescription = null,
                        modifier = Modifier
                            .height(280.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp)
                    ) {
                        Text(text = "EXPLORE NOW", fontSize = 14.sp, color = IconColor)
                    }
                    Row (
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(15.dp),
                            painter = painterResource(id = R.drawable.view_icon),
                            contentDescription = "view",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "154",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "views",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                    Icon(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(35.dp)
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.imags_icon),
                        contentDescription = "images",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Abu Simbel Temples",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Aswan, Egypt.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ios_share),
                            contentDescription = "Share",
                            tint = IconColor,
                            modifier = Modifier.size(20.dp)
                        )
                        IconButton(
                            onClick = { isLoved = true },
                            enabled = true,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Icon(
                                imageVector = if (isLoved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder ,
                                contentDescription = "love",
                                tint = IconColor,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Text(
                            text = "45",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))
                Divider(
                    modifier = Modifier
                        .padding(horizontal = 18.dp),
                    thickness = (0.5).dp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Description",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "The Abu Simbel temples are two massive rock temples at Abu Simbel, a village in Nubia, southern Egypt, near the border with Sudan. They are situated on the western bank of Lake Nasser, about 250 km southwest of Aswan (90 km by road). The twin temples were originally carved out of the mountainside in the 13th century BC, during the 19th dynasty reign of the Pharaoh Ramesses II. They serve as a lasting monument to the king and his queen Nefertari, and commemorate his victory at the Battle of Kadesh. Their huge external rock relief figures have become iconic.",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}


