package com.project.verbosetech.findout.Othes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sagar on 21/6/17.
 */

@SuppressLint("CommitPrefEdits")
public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Shared pref file name
    private static final String PREF_NAME = "AndroidHive";

    // Constructor
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setNumber(String number) {
        editor.putString("number", number);
        editor.commit();
    }

    public String getNumber() {
        return pref.getString("number", null);
    }

    public void setImage(int image) {
        editor.putInt("image", image);
        editor.commit();
    }

    public int getImage() {
        return pref.getInt("image", 0);
    }

}
