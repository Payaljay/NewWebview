package app.dev.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class WebActivity extends AppCompatActivity implements MyWebview.Listener {
    /*   private static final String TEST_PAGE_URL = "https://app.mobyads.in/publisher/A01234567/?fsMobile=" +
               "918140663133&fsEmail=johndeo@gmail.com&fsFirstName=Chirag&fsLastName=Kheni&fiDeviceType=0";*/
    MyWebview mWebView;
    String url;
    boolean isAccessStorage, isAccessGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        if (getIntent() != null) {
            url = getIntent().getStringExtra("url");
            isAccessGPS = getIntent().getBooleanExtra("isAccessGPS", false);
            isAccessStorage = getIntent().getBooleanExtra("isAccessStorage", false);
        }
        mWebView = findViewById(R.id.web);
        mWebView.setListener(this, this);
        mWebView.setGeolocationEnabled(isAccessGPS);
        mWebView.setAccessStorage(isAccessStorage);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(WebActivity.this, "Finished loading", Toast.LENGTH_SHORT).show();
            }

        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Toast.makeText(WebActivity.this, title, Toast.LENGTH_SHORT).show();
            }

        });
        //mWebView.addHttpHeader("Referer", "https://mobyads.in/");
        mWebView.loadUrl(url);
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        Log.d("TTT", "onResume call...");
        mWebView.onResume();
        super.onResume();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mWebView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mWebView.onActivityResult(requestCode, resultCode, data);
    }
}