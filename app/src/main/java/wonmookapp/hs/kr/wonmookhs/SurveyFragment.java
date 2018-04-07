package wonmookapp.hs.kr.wonmookhs;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SurveyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_survey, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("교내"));
        tabLayout.addTab(tabLayout.newTab().setText("교외"));
        tabLayout.addTab(tabLayout.newTab().setText("학생회"));
        tabLayout.addTab(tabLayout.newTab().setText("설문조사"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.pager);

        viewPager.setAdapter(new SurveyFragment.FragmentPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(1);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflatedView;
    }

    @Override
    public void onDestroyView() {
        Log.d("Wonmook", "OnDestroySurveyFragment");
        super.onDestroyView();
    }


    public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public FragmentPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Survey1 tab1 = new Survey1();
                    return tab1;
                case 1:
                    Survey2 tab2 = new Survey2();
                    return tab2;
                case 2:
                    Survey3 tab3 = new Survey3();
                    return tab3;
                case 3:
                    Survey4 tab4 = new Survey4();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }





    public static class Survey1 extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_musicapplication, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.musicapplication);
            lunch.loadUrl("https://goo.gl/forms/6ktxiYBNv2tZf1Fs2");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);


            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setUseWideViewPort(true);
            webSettings.getJavaScriptEnabled();
            webSettings.getJavaScriptCanOpenWindowsAutomatically();

            webSettings.setJavaScriptEnabled(true);

            lunch.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;




                }
            });


            return rootView;
        }


    }





    public static class Survey2 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_musicapplication, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.musicapplication);
            lunch.loadUrl("https://goo.gl/forms/MET2lPiP0b5kxySm2");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);


            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setUseWideViewPort(true);
            webSettings.getJavaScriptEnabled();
            webSettings.getJavaScriptCanOpenWindowsAutomatically();

            webSettings.setJavaScriptEnabled(true);

            lunch.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;


                }
            });


            return rootView;
        }

    }








    public static class Survey3 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_musicapplication, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.musicapplication);
            lunch.loadUrl("https://goo.gl/forms/L44FSIBW5cpfmxtc2");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);


            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setUseWideViewPort(true);
            webSettings.getJavaScriptEnabled();
            webSettings.getJavaScriptCanOpenWindowsAutomatically();

            webSettings.setJavaScriptEnabled(true);

            lunch.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;


                }
            });


            return rootView;
        }

    }








    public static class Survey4 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_musicapplication, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.musicapplication);
            lunch.loadUrl("https://goo.gl/forms/eSEYl5LqxfEY6xqm2");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);


            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setUseWideViewPort(true);
            webSettings.getJavaScriptEnabled();
            webSettings.getJavaScriptCanOpenWindowsAutomatically();

            webSettings.setJavaScriptEnabled(true);

            lunch.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;


                }
            });


            return rootView;
        }
    }




    public static class Etc1Fragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_musicapplication, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.musicapplication);
            lunch.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdptmM8PLhrHzxD7n4jj4nBNJ1NqH-MRKgDt6Ln773ZvtDcXQ/viewform?usp=sf_link");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);


            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setUseWideViewPort(true);
            webSettings.getJavaScriptEnabled();
            webSettings.getJavaScriptCanOpenWindowsAutomatically();

            webSettings.setJavaScriptEnabled(true);

            lunch.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return false;


                }
            });


            return rootView;
        }

    }





}