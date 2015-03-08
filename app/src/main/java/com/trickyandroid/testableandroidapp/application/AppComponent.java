package com.trickyandroid.testableandroidapp.application;

import com.trickyandroid.testableandroidapp.httpstack.HttpStackModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by paveldudka on 3/7/15.
 */
@Singleton
@Component(modules = {HttpStackModule.class})
public interface AppComponent extends AppGraph {
    /**
     * An initializer that creates the graph from an application.
     */
    final static class Initializer {
        static AppGraph init() {
            return init(new DiConfiguration());
        }

        static AppGraph init(DiConfiguration config) {
            return Dagger_AppComponent.builder()
                    .httpStackModule(new HttpStackModule(config.getHttpStack()))
                    .build();
        }

        private Initializer() {
        } // No instances.
    }
}
