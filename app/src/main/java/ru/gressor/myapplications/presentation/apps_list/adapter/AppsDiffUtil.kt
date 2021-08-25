package ru.gressor.myapplications.presentation.apps_list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.gressor.myapplications.domain.entities.App

class AppsDiffUtil : DiffUtil.ItemCallback<App>() {
    override fun areItemsTheSame(oldItem: App, newItem: App): Boolean =
        oldItem.appPackage == newItem.appPackage

    override fun areContentsTheSame(oldItem: App, newItem: App): Boolean = oldItem == newItem
}