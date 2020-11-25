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

public class tourWebActivity extends AppCompatActivity {
    WebView webViewtour;
    public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_web);
        webViewtour = findViewById(R.id.webviewtour);
        progressBar = (ProgressBar)findViewById(R.id.prg);
        webViewtour.setWebViewClient(new WebViewClient(){
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
        Intent intent = getIntent();

        String msg = intent.getStringExtra("place");
        switch(msg){
            case "hill" :

                webViewtour.loadUrl("https://leh.nic.in/tourist-places/");
                break;
            case "beach" :
//
                webViewtour.loadUrl("https://www.goatourism.gov.in/");
                break;
            case "raft" :
//
                webViewtour.loadUrl("https://uttarakhandtourism.gov.in/");
                break;
            case "hist" :
//
                webViewtour.loadUrl("https://tourism.bihar.gov.in/");
                break;
            case "solo" :
//
                webViewtour.loadUrl("http://www.jktourism.jk.gov.in/Lakes/Lakes.aspx");
                break;
            case "adv" :
//
                webViewtour.loadUrl("http://www.tourism.rajasthan.gov.in/tourist-destinations.html");

                break;
            case "delhi" :
//
                webViewtour.loadUrl("http://delhitourism.gov.in/delhitourism/index.jsp");
                break;
            case "sea" :
//
                webViewtour.loadUrl("https://lakshadweep.gov.in/tourism/adventures/");
                break;

        }
        WebSettings webSettings = webViewtour.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webViewtour.canGoBack()) {
            webViewtour.goBack();
        } else {
            super.onBackPressed();
        }
    }
}