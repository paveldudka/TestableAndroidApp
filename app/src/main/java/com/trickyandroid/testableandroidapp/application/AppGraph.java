package com.trickyandroid.testableandroidapp.application;

import com.trickyandroid.testableandroidapp.activities.MainActivity;

/**
 * Base application graph for dependency injection.
 * Whenever you have a class which has a dependency - separate inject method should be created for this class
 */
public interface AppGraph {
    void inject(MainActivity activity);
}
