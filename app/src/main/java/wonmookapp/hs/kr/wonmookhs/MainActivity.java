package wonmookapp.hs.kr.wonmookhs;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.FacebookSdk;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import static wonmookapp.hs.kr.wonmookhs.R.id.drawer_layout;
import static wonmookapp.hs.kr.wonmookhs.R.id.fragment2;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    ViewPager viewPager = null;
    Thread thread = null;
    Handler handler = null;
    int p = 0;
    int v = 1;

    SchoolSurveyFragment schoolSurveyFragment;
    Promotion1Fragment Promotion1Fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseInstanceId.getInstance().getToken();
        FacebookSdk.sdkInitialize(getApplicationContext());

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(drawer_layout);
        drawerToggle = setupDrawerToggle();
        // ...From section above...
        // Find our drawer view

        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        nvDrawer.setItemIconTintList(null);
        // Setup drawer view
        setupDrawerContent(nvDrawer);


        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        viewPager = (ViewPager) findViewById(R.id.homepager);
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        handler = new Handler() {

            public void handleMessage(android.os.Message msg) {
                if (p == 0) {
                    viewPager.setCurrentItem(1);
                    p++;
                } else if (p == 1) {
                    viewPager.setCurrentItem(0);
                    p--;
                } /*else if (p == 2) {
                    viewPager.setCurrentItem(3);
                    p++;
                } else if (p == 3) {
                    viewPager.setCurrentItem(0);
                    p--;
                    p--;
                    p--;
                }*/
            }
        };
        thread = new Thread() {
            //run은 jvm이 쓰레드를 채택하면, 해당 쓰레드의 run메서드를 수행한다.
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(3000);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        schoolSurveyFragment = new SchoolSurveyFragment();
    }






    public void onBackPressed()

    {

        DrawerLayout layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (layout.isDrawerOpen(GravityCompat.START)) {
            layout.closeDrawer(GravityCompat.START);
        } else {
        }


        // super.onBackPressed(); //지워야 실행됨

        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setMessage("원묵고 애플리케이션을 종료할까요?");


        d.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // process전체 종료
                finish();
            }
        });



        d.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        d.show();


    }




    public void onFragmenteChanged(int i) {
        if(i == 1) {
            //getSupportFragmentManager().beginTransaction().addToBackStack(schoolSurveyFragment.getTag()).replace(R.id.flContent, schoolSurveyFragment).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, Promotion1Fragment).commit();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }




    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                LinearLayout layout1 = (LinearLayout) findViewById(fragment2);
                layout1.setVisibility(View.VISIBLE);
                break;
            case R.id.nav_kakaotalk:
                fragmentClass = KakaotalkFragment.class;
                break;
            case R.id.nav_schoolschedule:
                fragmentClass = ScheduleFragment2.class;
                LinearLayout layout2 = (LinearLayout) findViewById(fragment2);
                layout2.setVisibility(View.GONE);
                break;

            case R.id.nav_lunch:
                fragmentClass = LunchFragment.class;
                break;
            case R.id.nav_mainboard:
                fragmentClass = MainboardFragment.class;
                break;
            case R.id.nav_newsletter:
                fragmentClass = NewsletterFragment.class;
                break;
            case R.id.nav_competition:
                fragmentClass = CompetitionFragment.class;
                break;
           case R.id.nav_afterschool:
               fragmentClass = AfterSchoolFragment.class;
               break;
            case R.id.nav_schoolsurvey:
                fragmentClass = SchoolSurveyFragment.class;
                break;

            case R.id.nav_facebookfragment:
                fragmentClass = FacebookFragment.class;
                break;

            case R.id.nav_promotion1:
                fragmentClass = Promotion1Fragment.class;
                break;
            case R.id.nav_teacherlocal:
                fragmentClass = TeacherLocalFragment.class;
                break;
            case R.id.nav_information:
                fragmentClass = InformationFragment.class;
                LinearLayout layout4 = (LinearLayout) findViewById(fragment2);
                layout4.setVisibility(View.GONE);
                break;

            case R.id.nav_about:
                fragmentClass = AboutFragment.class;
                LinearLayout layout5 = (LinearLayout) findViewById(fragment2);
                layout5.setVisibility(View.GONE);
                break;

            case R.id.nav_musicapplication:
                fragmentClass = MusicApplicationFragment.class;
                break;

            case R.id.nav_push:
                fragmentClass = PushDatabaseFragment.class;
                LinearLayout layout7 = (LinearLayout) findViewById(fragment2);
                layout7.setVisibility(View.GONE);
                break;

            case R.id.nav_survey:
                fragmentClass = SurveyFragment.class;
                LinearLayout layout8 = (LinearLayout) findViewById(fragment2);
                layout8.setVisibility(View.GONE);
                break;

            case R.id.nav_developer:
                fragmentClass = LoginFragment.class;
                LinearLayout layout9 = (LinearLayout) findViewById(fragment2);
                layout9.setVisibility(View.GONE);
                break;



            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }





    public static class Page_3 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page_3, container, false);

            return rootView;

        }

    }

    /**
     * Created by Administrator on 2017-02-18.
     */

    public static class Page_4 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page_4, container, false);

            return rootView;

        }

    }

    /**
     * Created by Administrator on 2017-02-18.
     */

    public static class Page_1 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page_1, container, false);

            return rootView;

        }

    }

    public static class Page_2 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page_2, container, false);

            //ImageButton button = (ImageButton) rootView.findViewById(R.id.btn_survey);
            //button.setOnClickListener(new View.OnClickListener() {
                //@Override
                //public void onClick(View v) {
                   // MainActivity activity = (MainActivity) getActivity();
                    //activity.onFragmenteChanged(1);
                //}
            //});

            return rootView;

        }

    }



}