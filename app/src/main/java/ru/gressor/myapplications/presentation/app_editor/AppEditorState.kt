package ru.gressor.myapplications.presentation.app_editor

sealed class AppEditorState {
    object New: AppEditorState()

    data class Old(
        val appPackage: String,
        val name: String,
        val tags: String = ""
    ) : AppEditorState()

    data class Error(val throwable: Throwable) : AppEditorState()
}