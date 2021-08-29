package ru.gressor.myapplications.presentation.apps_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.myapplications.databinding.ItemRecyclerAppsListBinding
import ru.gressor.myapplications.domain.entities.App

class ItemViewHolder(
    private val binding: ItemRecyclerAppsListBinding,
    private val onClickListener: (app: App) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(app: App) {
        views {
            captionTextView.text = app.name
            packageTextView.text = app.appPackage
            tagsTextView.text = app.tags
        }
        itemView.setOnClickListener {
            onClickListener(app)
        }
    }

    private fun <T> views(block: ItemRecyclerAppsListBinding.() -> T): T? = binding.block()

    companion object {
        fun create(parent: ViewGroup, onClickListener: (app: App) -> Unit) =
            ItemViewHolder(
                ItemRecyclerAppsListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), onClickListener
            )
    }
}