package wonmookapp.hs.kr.wonmookhs;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class AboutFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.pref_about);
    }
}