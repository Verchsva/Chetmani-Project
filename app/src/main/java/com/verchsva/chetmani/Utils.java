package com.verchsva.chetmani;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Ashutosh Srivastava on 27-Aug-2020 11:08 PM.
 * Project : SplashScreenWithLogIn
 * Copyright (c) 2020  All rights reserved.
 */
public class Utils {

    private static FirebaseDatabase instance;

    public static FirebaseDatabase getInstance() {
        if (instance == null) {
            instance = FirebaseDatabase.getInstance();
            instance.setPersistenceEnabled(true);
        }
        return instance;
    }

}
