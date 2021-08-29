package ru.gressor.myapplications.presentation.app_editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gressor.myapplications.domain.entities.App

class AppEditorVModelFactory(
    private val app: App?
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(AppEditorVModel::class.java) -> AppEditorVModel(app)
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
}