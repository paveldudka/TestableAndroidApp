package com.trickyandroid.testableandroidapp.httpstack;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpStackModule {
    private IHttpStack override;

    public HttpStackModule(IHttpStack httpStack) {
        this.override = httpStack;
    }

    @Provides
    @Singleton
    IHttpStack provideHttpStack() {
        if (override != null) {
            return override;
        } else {
            return new RealHttpStack();
        }
    }
}
