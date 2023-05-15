package com.example.android.worldcup.ui

import com.example.android.worldcup.data.domain.Match

interface MatchListner {
    fun onClickItem(match : Match)
    fun onClickTeamName(name : String)
}