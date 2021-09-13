package ru.gressor.myapplications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gressor.myapplications.databinding.ActivityMainBinding
import ru.gressor.myapplications.domain.entities.App
import ru.gressor.myapplications.presentation.app_editor.AppEditorFragment
import ru.gressor.myapplications.presentation.apps_list.AppsListFragment
import ru.gressor.myapplications.presentation.settings.SettingsFragment
import ru.gressor.myapplications.utils.di.ServiceLocator
import ru.gressor.myapplications.utils.navigation.Navigator

class MainActivity : AppCompatActivity(), Navigator {
    private var binding: ActivityMainBinding? = null
    private val containerId get() = views { fragmentContainer }?.id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ServiceLocator.register<Navigator>(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (savedInstanceState == null) {
            containerId?.let {
                supportFragmentManager.beginTransaction()
                    .add(it, AppsListFragment())
                    .commit()
            }
        }
    }

    override fun addNewApp() {
        containerId?.let {
            supportFragmentManager.beginTransaction()
                .replace(it, AppEditorFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun openAppEditor(app: App) {
        containerId?.let {
            supportFragmentManager.beginTransaction()
                .replace(it, AppEditorFragment.getInstance(app))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun openFilterEditor() {
        TODO("Not yet implemented")
    }

    override fun openSettingsEditor() {
        containerId?.let {
            supportFragmentManager.beginTransaction()
                .replace(it, SettingsFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun <T> views(block: ActivityMainBinding.() -> T): T? = binding?.block()
}