package ru.gressor.myapplications.data.repository

import ru.gressor.myapplications.data.db.entities.StoredApp
import ru.gressor.myapplications.domain.entities.App

fun StoredApp.toApp() = App(appPackage, name, tags, isInstalled)
fun App.toStoredApp() = StoredApp(appPackage, name, tags, isInstalled)