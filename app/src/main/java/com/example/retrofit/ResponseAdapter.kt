package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.response_view.view.*

class ResponseAdapter(val context: Context, val userlist : ArrayList<MydataItem>): RecyclerView.Adapter<ResponseAdapter.responseuser>() {


    class responseuser(itemView: View) : ViewHolder(itemView){
        val user_id : TextView
        val user_title : TextView

        init {
            user_id = itemView.user_id
            user_title = itemView.user_title
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): responseuser {
       var inflaterview = LayoutInflater.from(context).inflate(R.layout.response_view,parent,false)
        return responseuser(inflaterview)
    }

    override fun onBindViewHolder(holder: responseuser, position: Int) {
        holder.user_id.text = userlist[position].id.toString()
        holder.user_title.text = userlist[position].title.toString()
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}