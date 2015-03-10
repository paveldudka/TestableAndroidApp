package com.trickyandroid.testableandroidapp.activities;

import android.support.test.espresso.Espresso;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import com.trickyandroid.testableandroidapp.R;
import com.trickyandroid.testableandroidapp.application.App;
import com.trickyandroid.testableandroidapp.application.DiConfiguration;
import com.trickyandroid.testableandroidapp.httpstack.IHttpStack;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        App.getInstance(getInstrumentation().getTargetContext()).setDiConfig(new DiConfiguration().setHttpStack(new IHttpStack() {
            @Override
            public String getString() {
                return "Blah!";
            }
        }));
        getActivity();
    }

    public void testMainActivity() {
        onView(withId(R.id.request_btn)).perform(click());
        onView(withId(R.id.result_text)).check(matches(withText("Blah!")));
    }
}
