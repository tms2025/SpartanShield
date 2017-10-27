package inc.tms.develope.spartanshield2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import inc.tms.develope.spartanshield2.R;;

public class WebView extends AppCompatActivity {
    private android.webkit.WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        System.out.println("Received Message:" + url);
        myWebView = (android.webkit.WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new WebViewClient());


    }

    public void onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack();
        }

        else{
            super.onBackPressed();
        }
    }


        }


