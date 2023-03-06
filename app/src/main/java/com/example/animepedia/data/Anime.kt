package com.example.animepedia.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.animepedia.R

data class Anime(@DrawableRes val imageResourceId: Int,
                 @StringRes val name: Int,
                 val numofepisodes: Int,
                 @StringRes val Description: Int)


val Animes= listOf(Anime(R.drawable.am1, R.string.anime1,720,R.string.desc1),
    Anime(R.drawable.am2, R.string.anime2,1053,R.string.desc1),
    Anime(R.drawable.am3, R.string.anime3,50,R.string.desc1),
    Anime(R.drawable.am4, R.string.anime4,136,R.string.desc1),
    Anime(R.drawable.am5, R.string.anime5,175,R.string.desc1),
    Anime(R.drawable.am6, R.string.anime6,320,R.string.desc1),
    Anime(R.drawable.am7, R.string.anime7,85,R.string.desc1),
    Anime(R.drawable.am8, R.string.anime8,24,R.string.desc1),
    Anime(R.drawable.am9, R.string.anime9,88,R.string.desc9),
    Anime(R.drawable.am10, R.string.anime10,75,R.string.desc1),
    Anime(R.drawable.am11, R.string.anime11,300,R.string.desc1),


    )
