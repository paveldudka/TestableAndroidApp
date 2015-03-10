package com.trickyandroid.testableandroidapp.controller;

import com.trickyandroid.testableandroidapp.httpstack.IHttpStack;

import javax.inject.Inject;

public class RequestManager {

    @Inject
    IHttpStack httpStack;

    @Inject
    public RequestManager() {
    }

    /**
     * For testing purposes only! Do not call this constructor!
     *
     * @param httpStack
     */
    RequestManager(IHttpStack httpStack) {
        this();
        this.httpStack = httpStack;
    }

    /**
     * Request string
     */
    public String requestString() {
        return httpStack.getString();
    }
}
