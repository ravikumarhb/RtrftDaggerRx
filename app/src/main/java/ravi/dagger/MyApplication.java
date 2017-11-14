package ravi.dagger;

import android.app.Application;
import ravi.dagger.di.DaggerMyComponent;
import ravi.dagger.di.MyComponent;

/**
 * Created by 310239754 on 11/10/2017.
 */

public class MyApplication extends Application {

    MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        myComponent = DaggerMyComponent.builder().build();
    }

    public MyComponent getMyComponent(){
        return myComponent;
    }
}
