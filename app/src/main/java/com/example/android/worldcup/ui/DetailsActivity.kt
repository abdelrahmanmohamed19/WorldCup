package com.example.android.worldcup.ui

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import com.example.android.worldcup.data.DataManager
import com.example.android.worldcup.data.domain.Match
import com.example.android.worldcup.databinding.ActivityDetailsBinding
import com.example.android.worldcup.databinding.ActivityMainBinding
import com.example.android.worldcup.ui.viewHolders.Adapter
import com.example.android.worldcup.util.Constant
import com.example.android.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInfalter: (LayoutInflater) -> ActivityDetailsBinding = ActivityDetailsBinding::inflate

    override fun setup() {
        val match : Match = intent.getSerializableExtra(Constant.Key.Match) as Match
        match.let { bindMatch(it) }
    }

    private fun bindMatch(match: Match)
    {
        binding?.apply {
            team1.text=match.HomeTeamName
            team2.text=match.AwayTeamName
            score1.text=match.HomeTeamGoals.toString()
            score2.text=match.AwayTeamGoals.toString()
            year.text=match.year.toString()
        }
    }

    override fun addCallbacks() {
    }
}