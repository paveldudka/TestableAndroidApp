package com.trickyandroid.testableandroidapp.httpstack;

/**
 * Real(-ish) network stack. Returns hardcoded string :)
 */
public class RealHttpStack implements IHttpStack {
    @Override
    public String getString() {
        //make it feel like we are actually doing something here
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello from real network!";
    }
}
