package ru.gressor.myapplications.presentation.app_editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.gressor.myapplications.domain.IAppsRepository
import ru.gressor.myapplications.domain.entities.App
import ru.gressor.myapplications.presentation.app_editor.AppEditorState.*
import ru.gressor.myapplications.utils.di.locateLazily
import ru.gressor.myapplications.utils.navigation.Navigator

class AppEditorVModel(app: App?) : ViewModel() {

    private val repository: IAppsRepository by locateLazily()
    private val navigator: Navigator by locateLazily()

    private val _stateFlow = MutableStateFlow(
        app?.let { Old(appPackage = it.appPackage, name = it.name, tags = it.tags) } ?: New
    )
    val stateFlow = _stateFlow.asStateFlow()

    fun saveNewApp(appPackage: String, name: String, tags: String) {
        when {
            appPackage.isBlank() -> _stateFlow.value = Error(Throwable("Enter non-blank package!"))
            name.isBlank() -> _stateFlow.value = Error(Throwable("Enter non-blank name!"))
            else -> {
                viewModelScope.launch {
                    repository.save(App(appPackage, name, tags))
                    navigator.goBack()
                }
            }
        }
    }
}