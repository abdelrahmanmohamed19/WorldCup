package com.example.android.worldcup.data.domain

data class Match(
    val year : Int,
    val Staduim : String,
    val city : String,
    val HomeTeamName : String,
    val AwayTeamName : String,
    val HomeTeamGoals: Int,
    val AwayTeamGoals : Int,
)
