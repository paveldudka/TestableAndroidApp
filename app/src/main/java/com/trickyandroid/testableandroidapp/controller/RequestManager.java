package com.trickyandroid.testableandroidapp.controller;

import android.os.*;
import android.os.Process;
import android.support.annotation.NonNull;

import com.trickyandroid.testableandroidapp.httpstack.IHttpStack;

import javax.inject.Inject;

public class RequestManager {

    @Inject
    IHttpStack httpStack;
    Handler handler;

    @Inject
    public RequestManager() {
        handler = new Handler(Looper.getMainLooper());
    }

    public static interface ICallback {
        void onResult(String result);
    }

    /**
     * Request string asynchronously
     * @param callback
     */
    public void requestString(@NonNull final ICallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                reportResult(httpStack.getString(), callback);
            }
        }).start();
    }

    /**
     * Report result to the caller. Result is reported to the main thread
     * @param result
     * @param callback
     */
    private void reportResult(final String result, final ICallback callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onResult(result);
            }
        });
    }
}
