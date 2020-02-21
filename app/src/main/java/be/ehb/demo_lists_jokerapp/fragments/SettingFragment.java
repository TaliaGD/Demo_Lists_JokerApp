package be.ehb.demo_lists_jokerapp.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import be.ehb.demo_lists_jokerapp.R;

public class SettingFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

    }
}

