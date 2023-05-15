package com.example.android.worldcup.ui.viewHolders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android.worldcup.R
import com.example.android.worldcup.data.domain.Match
import com.example.android.worldcup.databinding.ItemMatchBinding
import com.example.android.worldcup.ui.MatchListner

class Adapter(val list :List<Match>,val listner: MatchListner) : RecyclerView.Adapter<Adapter.MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int)
    {
       val currentMatch = list[position]
        holder.binding.apply {
            name1.text=currentMatch.HomeTeamName
            name2.text=currentMatch.AwayTeamName
            score1.text=currentMatch.HomeTeamGoals.toString()
            score2.text=currentMatch.AwayTeamGoals.toString()
            year.text ="World Cup ${currentMatch.year.toString()}"
            name1.setOnClickListener { listner.onClickTeamName(currentMatch.HomeTeamName)}
            name2.setOnClickListener { listner.onClickTeamName(currentMatch.AwayTeamName)}
//            root.setOnClickListener{listner.onClickItem(currentMatch)}
        }
    }


    override fun getItemCount() = list.size

    class MatchViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)
    {
        val binding = ItemMatchBinding.bind(viewItem)
    }

}