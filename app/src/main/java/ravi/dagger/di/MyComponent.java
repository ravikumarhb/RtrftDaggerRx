package ravi.dagger.di;

import dagger.Component;
import ravi.dagger.MainActivity;

/**
 * Created by 310239754 on 11/10/2017.
 */

@Component(modules = {MyModule.class})
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
