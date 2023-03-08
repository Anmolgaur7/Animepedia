package com.example.animepedia

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animepedia.data.Anime
import com.example.animepedia.data.Animes
import com.example.animepedia.ui.theme.AnimePediaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimePediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =MaterialTheme.colors.primary
                ) {
                    Animeapp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Animeapp() {
Scaffold(topBar = { AnimeTopAppBar()})
{
LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background),)
{
 items(Animes)
 {
  Animeitem(anime = it)
 }
}
}
}
@Composable
fun Animeitem(anime:Anime,modifier: Modifier=Modifier)
{
    var expanded by remember{ mutableStateOf(false) }
    Card(modifier = Modifier.padding(20.dp))
    {
        Column(modifier=Modifier.animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))) 
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Cyan)
            )
            {
                Animeicon(anime.imageResourceId)
                AnimeName(anime.name)
                Spacer(modifier = Modifier.weight(1F))
                AnimeEp(anime.numofepisodes)
                AnimeClick(expanded,OnClick={expanded=!expanded})
            }
            if (expanded)
            {
                Spacer(modifier = Modifier.padding(5.dp))
                Animedesc(anime.Description)
            }
        }
        }
    }

@Composable
fun AnimeClick(expanded: Boolean, OnClick: () -> Unit) {
    IconButton(onClick = OnClick)
    {
        Icon(imageVector =if (expanded)Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, tint = Color.Red, contentDescription = null)
    }
}

@Composable
fun AnimeEp(Animeep:Int,modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(id =R.string.noe,Animeep),
            style = MaterialTheme.typography.h3,
            modifier = modifier
                .padding(top = 8.dp),
            fontSize = 30.sp
        )
    }
}

@Composable
fun AnimeName(@StringRes animename: Int, modifier: Modifier = Modifier)
{
    Column {
        Text(
            text = stringResource(animename),
            style = MaterialTheme.typography.h5,
            modifier = modifier.padding(top = 8.dp)
        )
        }
}

@Composable
fun Animeicon(@DrawableRes Animeicon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(Animeicon),

        contentDescription = null
    )
}

@Composable
fun Animedesc(@StringRes desc:Int, modifier: Modifier=Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        ).background(Color.LightGray)
    )
    {
        Text(text = stringResource(id =desc), style = MaterialTheme.typography.h5)
}
}
@Preview
@Composable
fun AnimePreview() {
    AnimePediaTheme(darkTheme = false) {
        Animeapp()
    }
}
@Composable
fun AnimeTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .padding(start = 20.dp, end = 8.dp, top = 20.dp, bottom =15.dp)
                .clip(RoundedCornerShape(60)),
            painter = painterResource(R.drawable.am0),
            contentDescription = null
        )
        Text(
            modifier=Modifier.padding(start =20.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            text = stringResource(R.string.app_name),
            fontSize = 45.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimePediaTheme {
        Animeapp()
    }
}