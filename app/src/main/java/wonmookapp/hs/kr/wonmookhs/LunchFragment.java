package wonmookapp.hs.kr.wonmookhs;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LunchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_lunchtab, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("급식"));
        tabLayout.addTab(tabLayout.newTab().setText("석식 교환"));
        tabLayout.addTab(tabLayout.newTab().setText("급식 건의"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.pager);

        viewPager.setAdapter(new LunchFragment.FragmentPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(0);

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
                    LunchFragment.Survey1 tab1 = new LunchFragment.Survey1();
                    return tab1;
                case 1:
                    LunchFragment.Survey2 tab2 = new LunchFragment.Survey2();
                    return tab2;
                case 2:
                    LunchFragment.Survey3 tab3 = new LunchFragment.Survey3();
                    return tab3;
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_lunch, container, false);
            WebView lunch = (WebView) rootView.findViewById(R.id.lunch);
            lunch.loadUrl("http://www.wonmook.hs.kr/7862/subMenu.do");

            WebSettings webSettings = lunch.getSettings();

            webSettings.setAllowFileAccess(true);

            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            webSettings.setLoadWithOverviewMode(true);

            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);

            webSettings.setJavaScriptEnabled(true);

            lunch.setOnKeyListener(new View.OnKeyListener()
            {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event)
                {
                    if(event.getAction() == KeyEvent.ACTION_DOWN)
                    {
                        WebView webView = (WebView) v;

                        switch(keyCode)
                        {
                            case KeyEvent.KEYCODE_BACK:
                                if(webView.canGoBack())
                                {
                                    webView.goBack();
                                    return true;
                                }
                                break;
                        }
                    }

                    return false;
                }
            });

            lunch.setDownloadListener(new DownloadListener() {
                @Override
                public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                    Uri source = Uri.parse(url);
                    String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                    DownloadManager.Request request = new DownloadManager.Request(source);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    }else{
                        request.setShowRunningNotification(true);
                    }
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                    DownloadManager dm = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    dm.enqueue(request);
                }
            });

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
            lunch.loadUrl("https://goo.gl/forms/EAtjA8jWEkePmbJQ2");

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
            lunch.loadUrl("https://goo.gl/forms/0xB6JK3y5NZtKrvG3");

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