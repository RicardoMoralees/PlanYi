package com.planyi.planyi;

import android.app.Application;
import android.content.Context;

public class Planyi extends Application {

    public static Session session;

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    public static void init(Context planyi) {
        session = Session.getInstance();
        session.init(planyi);
    }
}

