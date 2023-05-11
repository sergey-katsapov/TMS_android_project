package com.example.tms_android_project.ui.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android_project.R
import com.example.tms_android_project.ui.domain.models.DomainPostList

class RecyclerAdapter(
    private val items: DomainPostList,
    private val onItemClickEvent: (View) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyler_item, parent, false)

        itemView.setOnClickListener {
            onItemClickEvent(it)
        }

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            titleTextView.text = items.posts!![position].title //TODO
            descriptionTextView.text = items.posts[position].description
        }
    }

    override fun getItemCount(): Int {
        return items.posts!!.size //TODO
    }
}