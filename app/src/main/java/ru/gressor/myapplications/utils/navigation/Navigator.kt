package ru.gressor.myapplications.utils.navigation

import ru.gressor.myapplications.domain.entities.App

interface Navigator {
    fun openAppEditor(app: App)
    fun addNewApp()
    fun goBack()
}