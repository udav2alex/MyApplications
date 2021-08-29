package ru.gressor.myapplications.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class App(
    val id: Int,
    val appPackage: String,
    val name: String,
    val tags: String = "",
    val isInstalled: Boolean = false
): Parcelable