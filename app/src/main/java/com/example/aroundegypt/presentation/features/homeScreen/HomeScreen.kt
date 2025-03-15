package com.example.aroundegypt.presentation.features.homeScreen

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.aroundegypt.R
import com.example.aroundegypt.domain.entity.Data
import com.example.aroundegypt.domain.entity.Experience
import com.example.aroundegypt.domain.entity.ExperienceModel
import com.example.aroundegypt.presentation.component.ExperienceBottomSheet
import com.example.aroundegypt.ui.theme.IconColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val recommendedexperiences by viewModel.recommendedExperiences.collectAsState()
    val recentExperiences by viewModel.recentExperiences.collectAsState()

//    val recommendedList = recommendedexperiences.map { it.data }
//    val recentList = recentExperiences.map { it.data }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isBottomSheetOpen by rememberSaveable { mutableStateOf(false) }

    ExperienceBottomSheet(
        sheetState = sheetState,
        isOpen = isBottomSheetOpen,
        onDismissRequest = { isBottomSheetOpen = false }
    )

    Scaffold(
        topBar = { CustomTopAppBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 19.dp)
        ) {
            item {
                Text(
                    text = "Welcome!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Text(
                    text = "Now you can explore any experience in 360 " +
                            "degrees and get all the details about it all in " +
                            "one place.",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Most Recent",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            item {
                LazyColumn {
                    items(recommendedexperiences) { experience ->
                        ExperienceCard(
                            experience = experience,
                            onclick = { isBottomSheetOpen = true }
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Most Recent",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp, end = 19.dp)
                )
            }

            item {
                LazyColumn {
                    items(recentExperiences) { experience ->
                        ExperienceCard(
                            experience = experience,
                            onclick = { isBottomSheetOpen = true }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExperienceCard(
    experience: Data,
    onclick : () -> Unit = {}
) {

    var isLoved by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(bottom = 8.dp)
            .clickable { onclick() }
    ) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .padding(end = 6.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onclick() },
        ) {
            AsyncImage(
                model = experience.cover_photo,
                contentDescription = "Place Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
//            Image(
//                painter = painterResource(id = experience.imageUrl),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(37.dp),
                painter = painterResource(id = R.drawable.view360_icon),
                contentDescription = "View360",
                tint = Color.White
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(35.dp)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.info_icon),
                contentDescription = "info",
                tint = Color.White
            )
            Row (
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(25.dp)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.view_icon),
                    contentDescription = "view",
                    tint = Color.White
                )
                Text(
                    text = "154",
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

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                text = experience.title,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(100.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${experience.likes_no}",
                    fontSize = 14.sp,
                )
                IconButton(
                    onClick = { isLoved = true },
                    enabled = true,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Icon(
                        imageVector = if (isLoved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder ,
                        contentDescription = "love",
                        tint = IconColor
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = {
            SearchBar()
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Handle menu click */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle filter click */ }) {
                Icon(painter = painterResource(R.drawable.baseline_filter_list_24), contentDescription = "Filter")
            }
        },
    )
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5))
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Try “Luxor”",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RecommendedSection(recommendedExperiences: List<Experience>) {
//
//    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
//    var isBottomSheetOpen by rememberSaveable { mutableStateOf(false) }
//
//    ExperienceBottomSheet(
//        sheetState = sheetState,
//        isOpen = isBottomSheetOpen,
//        onDismissRequest = { isBottomSheetOpen = false }
//    )
//    Column {
//        Text(
//            text = "Most Recent",
//            fontSize = 22.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        LazyColumn {
//            items(recommendedExperiences) { experience ->
//                ExperienceCard(
//                    experience = experience,
//                    onclick = { isBottomSheetOpen = true }
//                )
//            }
//        }
//    }
//
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RecentSection(recentExperiences: List<Experience>) {
//
//    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
//    var isBottomSheetOpen by rememberSaveable { mutableStateOf(false) }
//
//    ExperienceBottomSheet(
//        sheetState = sheetState,
//        isOpen = isBottomSheetOpen,
//        onDismissRequest = { isBottomSheetOpen = false }
//    )
//    Column {
//        Text(
//            text = "Most Recent",
//            fontSize = 22.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 8.dp, end = 19.dp)
//        )
//
//        LazyColumn {
//            items(recentExperiences) { experience ->
//                ExperienceCard(
//                    experience = experience,
//                    onclick = { isBottomSheetOpen = true }
//                )
//            }
//        }
//    }
//
//}
//
//data class Experience0(
//    val id: Int,
//    val title: String,
//    val description: String,
////    val is_liked: Boolean,
//    val imageUrl: Int,
//    val likes_no: Int,
//)
//
//val listExperience = listOf{
//    Experience0(id = 1, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 2, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 3, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 4, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 5, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 6, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//    Experience0(id = 7, title = "Abu Simbel Temples", description = "", imageUrl = R.drawable.sample_img, likes_no = 12)
//}