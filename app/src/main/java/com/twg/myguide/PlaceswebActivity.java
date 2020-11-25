package com.twg.myguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Switch;

public class PlaceswebActivity extends AppCompatActivity {
    WebView webView;
    public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placesweb);
        webView = findViewById(R.id.webview);
        progressBar = (ProgressBar)findViewById(R.id.prgb);
          webView.setWebViewClient(new WebViewClient(){
              @Override
              public void onPageStarted(WebView view, String url, Bitmap favicon) {
                  super.onPageStarted(view, url, favicon);
                  progressBar.setVisibility(view.VISIBLE);
                  setTitle("Loading...");
              }

              @Override
              public void onPageFinished(WebView view, String url) {
                  super.onPageFinished(view, url);
                  progressBar.setVisibility(View.GONE);
                  setTitle(view.getTitle());

              }
          });
//        webView.loadUrl("https://en.wikipedia.org/wiki/Eiffel_Tower");
        Intent intent = getIntent();
        String msg = intent.getStringExtra("qrcode");
        switch(msg){
            case "Delhi" :
                //webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://en.wikipedia.org/wiki/India_Gate");
                break;
            case "Paris" :
//                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://en.wikipedia.org/wiki/Eiffel_Tower");
                break;
        }
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}