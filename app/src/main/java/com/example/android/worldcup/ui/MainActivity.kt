package com.example.android.worldcup.ui

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.widget.Toast
import com.example.android.worldcup.data.DataManager
import com.example.android.worldcup.data.domain.Match
import com.example.android.worldcup.databinding.ActivityMainBinding
import com.example.android.worldcup.ui.viewHolders.Adapter
import com.example.android.worldcup.util.Constant
import com.example.android.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>(),MatchListner{
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInfalter: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        openfile()
        val Adapter =Adapter(DataManager.matchList.reversed(),this)
        binding?.recyclerMatch?.adapter =Adapter
    }

    override fun addCallbacks() {
    }

    private fun openfile()
    {
        val inputStream = assets.open("WorldCupMatches.csv")
        val buffer=BufferedReader(InputStreamReader(inputStream))
        val parser =  CsvParser()
        buffer.forEachLine {
            val currentMatch=parser.parse(it)
            DataManager.addMatch(currentMatch)
        }
    }

    override fun onClickItem(match: Match) {
//        val intent = Intent(this,DetailsActivity::class.java)
//        intent.putExtra(Constant.Key.Match,match)
//        startActivity(intent)
    }

    override fun onClickTeamName(name: String) {
        Toast.makeText(applicationContext,name,Toast.LENGTH_SHORT).show()
    }

}

