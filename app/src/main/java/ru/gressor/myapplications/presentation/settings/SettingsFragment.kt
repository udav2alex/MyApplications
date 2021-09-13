package ru.gressor.myapplications.presentation.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.gressor.myapplications.R

class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.screen_settings)
    }
}