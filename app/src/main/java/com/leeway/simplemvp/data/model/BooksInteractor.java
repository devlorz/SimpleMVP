package com.leeway.simplemvp.data.model;

import com.leeway.simplemvp.data.model.BookSearchResult;

import retrofit2.Call;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public interface BooksInteractor {
    Call<BookSearchResult> search(String search);
}
