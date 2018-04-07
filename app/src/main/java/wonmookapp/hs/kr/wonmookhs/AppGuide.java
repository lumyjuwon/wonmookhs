package wonmookapp.hs.kr.wonmookhs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017-06-05.
 */

public class AppGuide extends AppCompatActivity {

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.appguide_activity);

        viewPager = (ViewPager) findViewById(R.id.AppGuideViewPager);
        AppGuideViewPagerAdapter adapter = new AppGuideViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        try {
            SharedPreferences mPref = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);

            Boolean bFirst = mPref.getBoolean("isFirst", false);

            if (bFirst == false) {
                Log.d("version", "first");

                /*SharedPreferences.Editor editor = mPref.edit();
                editor.putBoolean("isFirst", true);
                editor.commit();*/

                /*Intent intent = new Intent(this, AppGuide.class);
                startActivity(intent);
                finish();*/
            }

            else if (bFirst == true) {
                Log.d("version", "not first");

                Intent intent = new Intent(this, Splash.class);
                startActivity(intent);
                finish();
            }

        }

        catch (Exception execption) {

        }

    }

    public static class AppGuidePage1 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_1, container, false);
            return rootView;
        }
    }

    public static class AppGuidePage2 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_2, container, false);
            return rootView;
        }
    }

    public static class AppGuidePage3 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_3, container, false);
            return rootView;
        }
    }

    public static class AppGuidePage4 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_4, container, false);
            return rootView;
        }
    }

    public static class AppGuidePage5 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_5, container, false);
            return rootView;
        }
    }

    public static class AppGuidePage6 extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.appguide_page_6, container, false);
            return rootView;
        }
    }

    public void GoToMainActivity(View view) {

        SharedPreferences mPref = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPref.edit();

        editor.putBoolean("isFirst", true);
        editor.commit();

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);
        finish();
    }
}
