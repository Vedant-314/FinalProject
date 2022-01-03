package com.example.FinalApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postadapter(private var titleList:ArrayList<String>,
                  private var descriptionList: ArrayList<String>): RecyclerView.Adapter<postadapter.PostViewHolder>() {
    inner class PostViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView =view.findViewById(R.id.Title)
        val description: TextView =view.findViewById(R.id.Description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.title.text= titleList[position]
        holder.description.text= descriptionList[position]

    }

    override fun getItemCount(): Int {
        return titleList.size
    }
}

