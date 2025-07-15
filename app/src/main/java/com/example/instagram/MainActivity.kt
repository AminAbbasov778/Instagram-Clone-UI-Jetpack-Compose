package com.example.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var stories by remember {
        mutableStateOf(
            listOf(
                StoryModel(R.drawable.secondstoryimg, "sabanok..."),
                StoryModel(R.drawable.thirdstoryimg, "blue_bouy"),
                StoryModel(R.drawable.fourthstoryimg, "waggles"),
                StoryModel(R.drawable.fifthstoryimg, "steve.loves")
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            InstagramHeader()

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                item {
                    StoriesSection(stories)
                    Box(modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth().height(1.5.dp).background(colorResource(R.color.dot_grey)),)
                }
                item {
                    PostItem()
                }

            }
        }


        BottomNavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun InstagramHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp, start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Instagram",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold
            )
            Icon(
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = null,
                modifier = Modifier.width(50.dp)
            )
        }
        Row {
            listOf(Icons.Filled.Favorite, Icons.Filled.Message, Icons.Filled.Add).forEachIndexed { index, icon ->
                Icon(imageVector = icon, contentDescription = null)
                if (index < 2) Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Composable
fun StoriesSection(stories: List<StoryModel>) {
    LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally, ) {
                Box(modifier = Modifier.size(85.dp), contentAlignment = Alignment.BottomEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.mystoryimg),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.blue)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = colorResource(id = R.color.white),
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Ruffles", fontSize = 12.sp, modifier = Modifier.padding(start = 20.dp), color = colorResource(R.color.text_grey))
            }
        }
        items(stories) { story ->
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 6.dp)) {
                Box(modifier = Modifier.size(85.dp), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.storybg),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp).clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = story.img),
                        contentDescription = null,
                        modifier = Modifier.size(65.dp).clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = story.username, fontSize = 12.sp, maxLines = 1)
            }
        }
    }
}


@Composable
fun PostItem() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.mystoryimg),
                contentDescription = null,
                modifier = Modifier.size(50.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(17.dp))
            Text(text = "Ruffles", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        ImageSlider()
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.White
    ) {
        val icons = listOf(
            Icons.Filled.Home,
            Icons.Filled.Search,
            Icons.Filled.Videocam,
            Icons.Filled.ShoppingBasket
        )

        icons.forEachIndexed { index, icon ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                selected = currentIndex == index,
                onClick = { currentIndex = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }

        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.TopCenter) {
                    Image(
                        painter = painterResource(id = R.drawable.mystoryimg),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .border(
                                width = if (currentIndex == 4) 2.dp else 0.dp,
                                color = if (currentIndex == 4) Color.Black else Color.Transparent,
                                shape = CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )


                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .offset(y = 38.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    )
                }
            },
            selected = currentIndex == 4,
            onClick = { currentIndex = 4 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )

    }
}

@Composable
fun ImageSlider() {
    val images = arrayListOf(R.drawable.postimg1, R.drawable.postimg2, R.drawable.postimg3,R.drawable.postimg4,R.drawable.postimg5,R.drawable.postimg6)
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            state = pagerState,
            count = images.size,
            modifier = Modifier.fillMaxWidth().height(400.dp)
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Image ${page + 1}",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "${page + 1}/${images.size}",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(Color.Black.copy(alpha = 0.6f), CircleShape)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 18.dp,bottom = 60.dp)
                        
                        .size(35.dp)
                        .background(Color.Black.copy(alpha = 0.6f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        tint = colorResource(R.color.white),
                        modifier = Modifier.size(21.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(colorResource(R.color.blue))
                        .align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "CTA copy here",
                        color = colorResource(R.color.white),
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 20.dp), fontWeight = FontWeight.ExtraBold
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        tint = colorResource(R.color.white),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(33f), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = colorResource(R.color.red), modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(15.dp))
                Icon(imageVector = Icons.Outlined.ModeComment, contentDescription = null, modifier = Modifier.width(30.dp))
                Spacer(modifier = Modifier.width(15.dp))
                Icon(imageVector = Icons.Outlined.Send, contentDescription = null, modifier = Modifier.width(30.dp))
            }
            CustomPagerIndicator(images.size, pagerState.currentPage, Modifier.weight(33f))
            Icon(
                imageVector = Icons.Outlined.Bookmark,
                contentDescription = null,
                modifier = Modifier.weight(33f).size(30.dp).padding(start = 105.dp).align(Alignment.CenterVertically)
            )
        }
        
        Spacer(modifier = Modifier.width(5.dp))

        Text(text = "100 likes", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp,modifier = Modifier.align(Alignment.Start).padding(start = 20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding( start = 20.dp)) {
            Text(text = "Username", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
                fontSize = 18.sp,
                modifier = Modifier.weight(1f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun CustomPagerIndicator(pageCount: Int, currentPage: Int, modifier: Modifier = Modifier) {
    val visibleDots = getVisibleDots(pageCount, currentPage)
    val radiusList = generateRadiusListForVisible(visibleDots, currentPage)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        radiusList.forEach { (index, radius) ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .size(radius)
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage)
                            colorResource(id = R.color.dot_blue)
                        else
                            colorResource(id = R.color.dot_grey)
                    )
            )
        }
    }
}



fun generateRadiusListForVisible(visiblePages: List<Int>, currentPage: Int): List<Pair<Int, Dp>> {
    val radiusForDistance = mapOf(
        0 to 8.dp,
        1 to 8.dp,
        2 to 6.dp
    )

    return visiblePages.map { index ->
        val distance = kotlin.math.abs(currentPage - index)
        index to (radiusForDistance[distance] ?: 5.dp)
    }
}

fun getVisibleDots(pageCount: Int, currentPage: Int, maxVisible: Int = 9): List<Int> {
    val half = maxVisible / 2
    val start = maxOf(0, currentPage - half)
    val end = minOf(pageCount, start + maxVisible)

    return (start until end).toList()
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    InstagramTheme {
        HomeScreen()
    }
}
