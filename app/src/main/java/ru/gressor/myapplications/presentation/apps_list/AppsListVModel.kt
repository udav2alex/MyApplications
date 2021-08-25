package ru.gressor.myapplications.presentation.apps_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.gressor.myapplications.domain.IAppsRepository
import ru.gressor.myapplications.utils.di.locateLazily

class AppsListVModel: ViewModel() {
    private val repository: IAppsRepository by locateLazily()

    val stateFlow = repository.appsListFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())
}