package com.leeway.simplemvp.data.model;

import com.leeway.simplemvp.data.manager.GoogleBookService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public class BooksInteractorImpl implements BooksInteractor {

    private GoogleBookService service;

    public BooksInteractorImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GoogleBookService.class);
    }

    @Override
    public Call<BookSearchResult> search(String search) {
        return service.search("search+" + search);
    }
}
