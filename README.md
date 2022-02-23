Installation

Add this library to your project Declare the Gradle repository in your root build.gradle

allprojects { repositories { maven { url "https://jitpack.io" } } } Declare the Gradle dependency in your app module's build.gradle

dependencies {  implementation 'com.github.Payaljay:NewWebview:1.0.0'}

Usage AndroidManifest.xml

Layout (XML) <app.dev.myapplication.MyWebview android:id="@+id/webview" android:layout_width="match_parent" android:layout_height="match_parent" />

Activity (Java) Without Fragments public class WebActivity extends AppCompatActivity implements MyWebview.Listener { private static final String TEST_PAGE_URL = ""; MyWebview mWebView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web);

    mWebView = findViewById(R.id.web);
    mWebView.setListener(this, this);
    mWebView.setGeolocationEnabled(true);
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
    mWebView.addHttpHeader("Referer", "https://mobyads.in/");
    mWebView.loadUrl(TEST_PAGE_URL);
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
