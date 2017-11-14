package ravi.dagger.di;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 310239754 on 11/10/2017.
 */

@Module
public class MyModule {

    @Provides
    MyNetwork providesNetwork() {
        return new MyNetwork();
    }

    @Provides
    MyPref providesPref(){
        return new MyPref();
    }

}
