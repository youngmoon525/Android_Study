package com.example.mysearchaddress;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mysearchaddress.R;

public class SearchAddrActivity extends AppCompatActivity {

    private WebView browser;

    class MyJavaScriptInterface
    {
        @JavascriptInterface
        @SuppressWarnings("unused")
        public void processDATA(String addr) {

            Bundle extra = new Bundle();
            Intent intent = new Intent();
            String[] dataArr = addr.split(",");
            addr = dataArr[1].toString().substring(0, dataArr[1].toString().indexOf("("));
            extra.putString("addr", addr);
            extra.putString("post", dataArr[0]);
            intent.putExtras(extra);
            setResult(RESULT_OK, intent);
            finish();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_addr);

        browser = (WebView) findViewById(R.id.daum_webview);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.addJavascriptInterface(new MyJavaScriptInterface(), "Android");

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                browser.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

      browser.loadUrl("http://www.inspond.com/daum.html");

    }
}//onCreateView