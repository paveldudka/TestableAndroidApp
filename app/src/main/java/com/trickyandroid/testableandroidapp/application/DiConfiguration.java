package com.trickyandroid.testableandroidapp.application;

import com.trickyandroid.testableandroidapp.httpstack.IHttpStack;

/**
 * Dependency configuration class
 */
public class DiConfiguration {
    private IHttpStack httpStack;

    public IHttpStack getHttpStack() {
        return httpStack;
    }

    public DiConfiguration setHttpStack(IHttpStack httpStack) {
        this.httpStack = httpStack;
        return this;
    }
}
