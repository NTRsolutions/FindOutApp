package com.project.verbosetech.findout;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by this pc on 05-06-17.
 */

public class MyApp extends Application {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Ubuntu-M.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}