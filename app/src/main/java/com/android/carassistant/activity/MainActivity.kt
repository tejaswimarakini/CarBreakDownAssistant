package com.android.carassistant.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.carassistant.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


/*fun constructMenuList(): ArrayList<HomeMenuData> {
    val homeMenuList = ArrayList<HomeMenuData>()
    homeMenuList.add(HomeMenuData("Fuel"))
    homeMenuList.add(HomeMenuData("Hospital"))
    homeMenuList.add(HomeMenuData("Restaurants"))
    homeMenuList.add(HomeMenuData("Emergency"))

    return homeMenuList
}*/


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DrawHomeMenuList(viewModel.constructMenuList())
        }
    }
}


@Composable
fun DrawHomeMenuList(homeMenuList: List<HomeMenuData>) {
    LazyColumn {
        items(homeMenuList) { homeMenuData ->
            DrawHomeMenu(homeMenuData)
        }
    }
}

@Composable
fun DrawHomeMenu(homeMenuData: HomeMenuData) {
    val context = LocalContext.current
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .padding(start = 30.dp, top = 30.dp, end = 30.dp)
            .width(500.dp)
            .height(100.dp)
            .clickable {
                context.startActivity(Intent(context, MapActivity::class.java))
            },
        backgroundColor = Color.LightGray,
    ) {

        Text(
            text = homeMenuData.name,
            fontSize = 30.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = 20.dp)
        )

    }
}

data class HomeMenuData(val name: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
       // DrawHomeMenuList()
    }
}