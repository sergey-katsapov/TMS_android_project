package com.example.tms_android_project.ui.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.PostItemBinding
import com.example.tms_android_project.ui.domain.models.DomainPost

class RecyclerAdapter(
    private val items: List<DomainPost>,
    private val onItemClickEvent: (View) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    //DO-4 работаем с холдером, проносим сюда view binding
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleTextView: TextView = itemView.findViewById(R.id.title)
//        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
//    }

    class MyViewHolder(itemPersonBinding: PostItemBinding) : RecyclerView.ViewHolder(itemPersonBinding.root) {
        val titleTextView: TextView = itemPersonBinding.title
        val descriptionTextView: TextView = itemPersonBinding.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //DO-5 работаем с view-holder, проносим сюда view binding

//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.post_item, parent, false)
//
//        itemView.setOnClickListener {
//            onItemClickEvent(it)
//        }
//
//        return MyViewHolder(itemView)

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = PostItemBinding.inflate(layoutInflater, parent, false)

        itemPersonBinding.root.setOnClickListener {
            onItemClickEvent(it)
        }

        return MyViewHolder(itemPersonBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            titleTextView.text = items[position].title
            descriptionTextView.text = items[position].publishedAt
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}