package ru.gressor.myapplications.presentation.apps_list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.gressor.myapplications.domain.entities.App

class AppsListAdapter : ListAdapter<App, ItemViewHolder>(AppsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder.create(parent)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}