package com.verchsva.chetmani;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private final SharedPreferences sharedPreferences;
    private static SharedPref sharedPref;

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("SHARED_PREF_NAME", Context.MODE_PRIVATE);
    }

    public static SharedPref getInstance(Context context) {
        if (sharedPref == null)
            sharedPref = new SharedPref(context);
        return sharedPref;
    }

    public void setUserRegistered(boolean status) {
        sharedPreferences.edit().remove("USER_STATUS").putBoolean("USER_STATUS", status).apply();
    }

    public boolean isUserRegistered(){
       return sharedPreferences.getBoolean("USER_STATUS", false);}
}
