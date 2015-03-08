package com.trickyandroid.testableandroidapp.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.trickyandroid.testableandroidapp.R;
import com.trickyandroid.testableandroidapp.application.App;
import com.trickyandroid.testableandroidapp.controller.RequestManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Inject
    RequestManager requestManager;

    @InjectView(R.id.result_text)
    TextView textView;

    @InjectView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        App.getInstance(this).getAppGraph().inject(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @OnClick(R.id.request_btn)
    void onRequestBtnClicked() {
        showProgressBar();
        requestManager.requestString(new RequestManager.ICallback() {
            @Override
            public void onResult(String result) {
                hideProgressBar();
                textView.setText(result);
            }
        });
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                progressBar.getViewTreeObserver().removeOnPreDrawListener(this);
                progressBar.setScaleX(0);
                progressBar.setScaleY(0);
                progressBar.animate().scaleX(1).scaleY(1).start();
                return true;
            }
        });
    }

    private void hideProgressBar() {
        progressBar.animate().scaleX(0).scaleY(0).withEndAction(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }).start();
    }
}
