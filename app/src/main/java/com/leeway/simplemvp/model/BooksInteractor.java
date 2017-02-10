package com.leeway.simplemvp.model;

import com.leeway.simplemvp.model.BookSearchResult;

import retrofit2.Call;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public interface BooksInteractor {
    Call<BookSearchResult> search(String search);
}
