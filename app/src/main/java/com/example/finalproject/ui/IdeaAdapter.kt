package com.example.finalproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.IdeaEntity

class IdeaAdapter : ListAdapter<IdeaEntity, IdeaAdapter.IdeaViewHolder>(IdeasComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return IdeaViewHolder(view)
    }

    override fun onBindViewHolder(holder: IdeaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.title, current.description)
    }

    class IdeaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.item_title)
        private val descriptionView: TextView = itemView.findViewById(R.id.item_description)

        fun bind(title: String?, description: String?) {
            titleView.text = title
            descriptionView.text = description
        }
    }

    class IdeasComparator : DiffUtil.ItemCallback<IdeaEntity>() {
        override fun areItemsTheSame(oldItem: IdeaEntity, newItem: IdeaEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: IdeaEntity, newItem: IdeaEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
