package app.dev.myapplication;

import android.content.Intent;

public class FinestWebViewBuilder {
    String url;
    // Activity context;
    boolean isAccessGPS;
    boolean isAccessStorage;

    public FinestWebViewBuilder(String url, boolean isLocationOn, boolean isWritePermission) {
        this.url = url;
        this.isAccessGPS = isLocationOn;
        this.isAccessStorage = isWritePermission;
    }

    public FinestWebViewBuilder() {

    }

   /* public FinestWebViewBuilder(Activity context) {
        this.context = context;
    }*/

    public FinestWebViewBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public FinestWebViewBuilder setAccessGPS(boolean accessGPS) {
        isAccessGPS = accessGPS;
        return this;
    }

    public FinestWebViewBuilder setAccessStorage(boolean accessStorage) {
        isAccessStorage = accessStorage;
        return this;
    }

    public FinestWebViewBuilder build() {
        return new FinestWebViewBuilder(url, isAccessGPS, isAccessStorage);
    }

    public void loadWebView() {
        if (LibApp.getContext() != null) {
            Intent intent = new Intent(LibApp.getContext(), WebActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("isAccessGPS", isAccessGPS);
            intent.putExtra("isAccessStorage", isAccessStorage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            LibApp.getContext().startActivity(intent);
        }
    }
}
