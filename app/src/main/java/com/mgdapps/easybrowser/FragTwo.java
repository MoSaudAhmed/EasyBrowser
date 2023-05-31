package com.mgdapps.easybrowser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragTwo extends Fragment {

    Button btn_search_home, btn_search_refresh;

    public static WebView wv_searchWeb;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_frag_two, container, false);

        btn_search_home = (Button) view.findViewById(R.id.btn_search_home);
        btn_search_refresh = (Button) view.findViewById(R.id.btn_search_refresh);


        wv_searchWeb = (WebView) view.findViewById(R.id.wv_searchweb);


        wv_searchWeb.getSettings().setDisplayZoomControls(false);
        wv_searchWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv_searchWeb.getSettings().setSupportMultipleWindows(false);
        wv_searchWeb.getSettings().setJavaScriptEnabled(true);
        wv_searchWeb.getSettings().setBuiltInZoomControls(true);
        wv_searchWeb.setWebChromeClient(new MyWebClient());
        wv_searchWeb.setWebViewClient(new webserver());

        wv_searchWeb.loadUrl("https://www.google.com/");

        wv_searchWeb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN)
                    return true;

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (wv_searchWeb.canGoBack()) {
                        wv_searchWeb.goBack();

                    } else {


                        startActivity(new Intent(getActivity(),MainActivity.class));

                    }

                    return true;
                }

                return false;
            }
        });


        btn_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wv_searchWeb.loadUrl("https://www.google.com/");

            }
        });

        btn_search_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String reload= wv_searchWeb.getUrl().toString();
                wv_searchWeb.loadUrl(reload);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
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
            if (FragTwo.this == null) {
                return null;
            }
            return BitmapFactory.decodeResource(FragTwo.this.getActivity().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) FragTwo.this.getActivity().getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            FragTwo.this.getActivity().getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            FragTwo.this.getActivity().setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = FragTwo.this.getActivity().getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = FragTwo.this.getActivity().getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) FragTwo.this.getActivity().getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            FragTwo.this.getActivity().getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    private class webserver extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            wv_searchWeb.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wv_searchWeb.onPause();
    }
}
