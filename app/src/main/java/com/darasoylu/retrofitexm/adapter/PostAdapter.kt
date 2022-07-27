package com.darasoylu.retrofitexm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darasoylu.retrofitexm.R
import com.darasoylu.retrofitexm.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var postList = emptyList<Post>()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.userId_txt).text = postList[position].userId.toString()
        holder.itemView.findViewById<TextView>(R.id.id_txt).text = postList[position].id.toString()
        holder.itemView.findViewById<TextView>(R.id.title_txt).text = postList[position].title
        holder.itemView.findViewById<TextView>(R.id.body_txt).text = postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setData(newPostList: List<Post>) {
        postList = newPostList
        notifyDataSetChanged()
    }
}