package ru.gressor.myapplications.presentation.apps_list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.gressor.myapplications.domain.entities.App

class AppsListAdapter(
    private val onClickListener: (app: App) -> Unit
) : ListAdapter<App, ItemViewHolder>(AppsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder.create(parent, onClickListener)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}