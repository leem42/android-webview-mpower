package com.example.mtlee.webview_mpower;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.KeyEvent;

import com.example.mtlee.webview_mpower.R.id.*;


public class MainActivity extends AppCompatActivity {


    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to handle app links.
        // Get the url the user clicked to launch the app
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.getSettings().setAppCacheEnabled(false);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.reload();
        myWebView.loadUrl("http://web-mpower-2-michael.lee.s3-website-us-east-1.amazonaws.com/feat/vuetify-alternate-checkboxes/#/");

    }

    // here we can intercept deep links and pass data to the site
    // so the user is put in the correct spot
    private void handleIntent(Intent intent) {
        Uri appLinkData = intent.getData();
        String appLinkAction = intent.getAction();
    }

    // here we can add history navigation to our app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
