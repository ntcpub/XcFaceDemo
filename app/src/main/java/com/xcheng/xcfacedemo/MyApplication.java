package com.xcheng.xcfacedemo;

import android.app.Application;

import com.xcheng.face.XCFace;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XCFace.init(this);
    }
}
