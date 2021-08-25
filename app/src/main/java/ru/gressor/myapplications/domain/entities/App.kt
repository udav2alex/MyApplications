package ru.gressor.myapplications.domain.entities

data class App(
    val appPackage: String,
    val name: String,
    val tags: String = "",
    val isInstalled: Boolean = false
)