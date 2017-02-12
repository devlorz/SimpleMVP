package com.leeway.simplemvp.data.manager;

import com.leeway.simplemvp.data.model.BookSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public interface GoogleBookService {
    @GET("books/v1/volumes")
    Call<BookSearchResult> search(@Query("q") String search);
}
