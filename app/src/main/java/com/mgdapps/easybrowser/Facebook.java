package com.mgdapps.easybrowser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Facebook extends AppCompatActivity {

    WebView webView;
 //   AdView mainbanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

      /*  mainbanner = (AdView) findViewById(R.id.main_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        mainbanner.loadAd(adRequest);

//         <com.google.android.gms.ads.AdView
        android:id="@+id/main_banner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        ads:adSize="BANNER"
        ads:adUnitId="ca-app-pub-6192240920670894/3911476165"
//      ></com.google.android.gms.ads.AdView>
*/
        final InterstitialAd interstitialAd = new InterstitialAd(getApplicationContext());

        String fullid = "ca-app-pub-6192240920670894/7863997762";
        interstitialAd.setAdUnitId(fullid);
        AdRequest adRequestfull = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequestfull);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }
        });


        webView = (WebView) findViewById(R.id.wv_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebChromeClient(new MyWebClient());
 //     webView.setWebViewClient(new Browser());
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportMultipleWindows(false);

        String result = getIntent().getExtras().getString("result");

        webView.loadUrl(result);

        webView.setWebViewClient(new webserver());
    }



    public class MyWebClient
            extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        public MyWebClient() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (Facebook.this == null) {
                return null;
            }
            return BitmapFactory.decodeResource(Facebook.this.getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) Facebook.this.getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            Facebook.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            Facebook.this.setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = Facebook.this.getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = Facebook.this.getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) Facebook.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            Facebook.this.getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    @Override
    protected void onDestroy() {
      /*  if (mainbanner != null) {
            mainbanner.destroy();
        }*/
        super.onDestroy();
    }

    @Override
    protected void onPause() {
       /* if (mainbanner != null) {
            mainbanner.pause();
        }*/
        super.onPause();

    }

    @Override
    protected void onResume() {
       /* if (mainbanner != null) {
            mainbanner.resume();
        }*/
        super.onResume();
    }

    private class webserver extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
