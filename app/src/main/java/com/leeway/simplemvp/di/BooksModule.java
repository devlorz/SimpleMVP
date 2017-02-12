package com.leeway.simplemvp.di;

import com.leeway.simplemvp.data.model.BooksInteractor;
import com.leeway.simplemvp.data.model.BooksInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Lee Lorz on 2/13/2017.
 */

@Module
public class BooksModule {
    @Provides
    public BooksInteractor providesBooksInteractor() {
        return new BooksInteractorImpl();
    }
}
