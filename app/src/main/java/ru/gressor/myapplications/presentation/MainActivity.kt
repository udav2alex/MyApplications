package ru.gressor.myapplications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gressor.myapplications.databinding.ActivityMainBinding
import ru.gressor.myapplications.presentation.apps_list.AppsListFragment

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (savedInstanceState == null) {
            val containerId = views { fragmentContainer }?.id
                ?: throw RuntimeException("Can't find ID for fragment_container!")
            supportFragmentManager.beginTransaction()
                .add(containerId, AppsListFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun <T> views(block: ActivityMainBinding.() -> T): T? = binding?.block()
}