package app.dev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TEST_PAGE_URL = "https://app.mobyads.in/publisher/A01234567/?fsMobile=918140663133&fsEmail=johndeo@gmail.com&fsFirstName=Chirag&fsLastName=Kheni&fiDeviceType=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FinestWebViewBuilder builder = new FinestWebViewBuilder().
                        setAccessStorage(true).
                        setAccessGPS(true).
                        setUrl(TEST_PAGE_URL).
                        build();
                builder.loadWebView();
            }
        });
    }
}