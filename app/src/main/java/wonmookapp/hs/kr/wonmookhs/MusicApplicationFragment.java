package wonmookapp.hs.kr.wonmookhs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URISyntaxException;

/**
 * Created by Administrator on 2017-04-15.
 */

public class MusicApplicationFragment extends android.support.v4.app.Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        lunch.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);

            }
        });






        return rootView;
    }


}
