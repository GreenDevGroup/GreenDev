package com.bmao.greendevapp.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.bmao.greendevapp.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}