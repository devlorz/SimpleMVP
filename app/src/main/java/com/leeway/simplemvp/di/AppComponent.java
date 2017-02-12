package com.leeway.simplemvp.di;

import com.leeway.simplemvp.ui.MainActivity;

import dagger.Component;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

@Component(modules = {BooksModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
