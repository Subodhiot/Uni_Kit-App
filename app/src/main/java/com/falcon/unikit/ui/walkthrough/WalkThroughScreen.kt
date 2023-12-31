package com.falcon.unikit.ui.walkthrough

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.falcon.unikit.LottieAnimation
import com.falcon.unikit.R
import com.google.accompanist.pager.HorizontalPagerIndicator

val walkThroughPagerContent = listOf(
    WalkThroughPager(R.raw.animation_comic, "Welcome to Unikit", "Empowering Academic Excellence."),
    WalkThroughPager(R.raw.translate_animation, "Streamlined Resources", "Effortless Access to Notes, Books, and More."),
    WalkThroughPager(R.raw.multiple_inputs, "Bridging the Knowledge Gap", "Access, Discuss, Learn, Grow.")
)
@Preview
@Composable
fun _WalkThroughScreen() {
    WalkThroughScreen {

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WalkThroughScreen(
    onNextCLick: () -> Unit
) {
    val pageState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.custom_color_primary))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white))
                .padding(13.dp)
        ) {
            HorizontalPagerIndicator(
                pagerState = pageState,
                pageCount = walkThroughPagerContent.size,
                modifier = Modifier
                    .padding(8.dp),
                activeColor = colorResource(id = R.color.custom_color_secondary)
            )
            Text(
                text = "Skip",
                style = TextStyle(
                    fontSize = 16.sp,
                ),
                color = colorResource(id = R.color.custom_color_primary),
                modifier = Modifier
                    .clickable {
//                        currentPage.value = PAGES.LOGIN
                        onNextCLick()
                    }
            )
        }

        HorizontalPager(
            pageCount = walkThroughPagerContent.size,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f),
            pageContent = { page ->
                ScreenUI(walkThroughPagerContent[page])
            }
        )
        val customButtonColors = buttonColors(
            containerColor = colorResource(id = R.color.custom_color_secondary),
            contentColor = Color.White
        )
        Button(
            colors = customButtonColors,
            elevation = androidx.compose.material3.ButtonDefaults.buttonElevation(
                8.dp
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(56.dp),
            onClick = {
//                currentPage.value = PAGES.LOGIN
                onNextCLick()
            }) {
            Text(
                text = "Get Started"
            )
        }
    }
}

@Composable
fun ScreenUI(pager: WalkThroughPager) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = CornerSize(0.dp),
                    topEnd = CornerSize(0.dp),
                    bottomStart = CornerSize(50.dp),
                    bottomEnd = CornerSize(50.dp)
                )
            )
            .fillMaxSize(1f)
            .background(colorResource(id = R.color.white))
    ) {
        LottieAnimation(pager.image)
        Text(
            text = pager.title,
            style = TextStyle(
                fontSize = 20.sp, // Set the desired font size
                fontWeight = FontWeight.Bold // Optional: Set the desired font weight
            )
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = pager.description,
            style = TextStyle(
                fontSize = 16.sp, // Set the desired font size
                fontWeight = FontWeight.Bold // Optional: Set the desired font weight
            ),
            modifier = Modifier
                .padding(24.dp)
        )
    }

}