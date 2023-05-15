package com.example.android.worldcup.util

import com.example.android.worldcup.data.domain.Match

class CsvParser {
    fun parse(line : String) : Match
    {
        val tokens =line.split(",")
        return Match(
            year = tokens[Constant.ColumnIndex.YEAR].toInt(),
            Staduim = tokens[Constant.ColumnIndex.STADUIM],
            city = tokens[Constant.ColumnIndex.CITY],
            HomeTeamName = tokens[Constant.ColumnIndex.HOME_TEAM_NAME],
            AwayTeamName = tokens[Constant.ColumnIndex.AWAY_TEAM_NAME],
            HomeTeamGoals = tokens[Constant.ColumnIndex.HOME_TEAM_GOALS].toInt(),
            AwayTeamGoals = tokens[Constant.ColumnIndex.AWAY_TEAM_GOALS].toInt(),
        )
    }
}