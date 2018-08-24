package com.exceptionbridge.exceptionthrower;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExceptionModule extends ReactContextBaseJavaModule {

    public ExceptionModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ExceptionModule";
    }

    @ReactMethod
    public void throwNativeException(
            String message,
            Promise promise) {
        try {
            throw new Exception(message);
            // promise.resolve("done");
        } catch (Exception e) {
            // the first argument is a code and the second a message
            // this e is never passed to the JS side
            promise.reject("my.error.code", message, e);
        }
    }
}
