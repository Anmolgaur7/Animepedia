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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    color = MaterialTheme.colors.background
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
    Card(modifier = Modifier.padding(8.dp))
    {
        Column(modifier=Modifier.animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))) 
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colors.surface))
            {
                Animeicon(anime.imageResourceId)
                AnimeName(anime.name)
                AnimeEp(anime.numofepisodes)
                AnimeClick(expanded,OnClick={expanded=!expanded})
            }
        }
        if (expanded)
        {
         Animedesc(anime.Description)
        }
        }
    }

@Composable
fun AnimeClick(expanded: Boolean, OnClick: () -> Unit) {
    IconButton(onClick = OnClick)
    {
       
    }
}

@Composable
fun AnimeEp(Animeep:Int,modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(id =R.string.noe,Animeep),
            style = MaterialTheme.typography.h3,
            modifier = modifier
                .padding(top = 8.dp)
                .size(20.dp)
        )
    }
}

@Composable
fun AnimeName(@StringRes animename: Int, modifier: Modifier = Modifier)
{
    Column {
        Text(
            text = stringResource(animename),
            style = MaterialTheme.typography.h3,
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
        )
    )
    {
        Text(text = stringResource(id =desc), style = MaterialTheme.typography.h3)
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
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.am1),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
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