package com.trickyandroid.testableandroidapp.httpstack;

/**
 * Real(-ish) network stack. Returns hardcoded string :)
 */
public class RealHttpStack implements IHttpStack {
    @Override
    public String getString() {
        return "Hello from real network!";
    }
}
