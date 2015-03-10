package com.trickyandroid.testableandroidapp.controller;

import com.trickyandroid.testableandroidapp.httpstack.IHttpStack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class RequestManagerTests {
    RequestManager manager;
    IHttpStack mockedStack;

    @Before
    public void init() {
        mockedStack = Mockito.mock(IHttpStack.class);
        manager = new RequestManager(mockedStack);
    }

    @Test
    public void simpleRequest() {
        manager.requestString();

        //make sure getString gets called only once
        verify(mockedStack, times(1)).getString();
    }
}