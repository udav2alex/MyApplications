package ru.gressor.myapplications.data.repository

import ru.gressor.myapplications.data.db.entities.StoredApp
import ru.gressor.myapplications.domain.entities.App

fun StoredApp.toApp() = App(id, appPackage, name, tags, isInstalled)
fun App.toStoredApp() = StoredApp(id, appPackage, name, tags, isInstalled)