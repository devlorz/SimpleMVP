package com.leeway.simplemvp;

import com.leeway.simplemvp.model.BookSearchResult;
import com.leeway.simplemvp.model.BooksInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public class BooksPresenter {
    BooksView view;
    private BooksInteractor interactor;

    public BooksPresenter(BooksInteractor interactor) {
        this.interactor = interactor;
    }

    public void bind(BooksView view) {
        this.view = view;
    }

    public void unbind() {
        view = null;
    }

    public void performSearch(String userInput) {
        String formatUserInput = userInput.trim().replaceAll("\\s+", "+");
        interactor.search("search+" + formatUserInput)
                .enqueue(new Callback<BookSearchResult>() {
                    @Override
                    public void onResponse(Call<BookSearchResult> call
                            , Response<BookSearchResult> response) {
                        if (view != null) {
                            view.updateUi(response.body().getBooks());
                        }
                    }

                    @Override
                    public void onFailure(Call<BookSearchResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
