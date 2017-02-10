package com.leeway.simplemvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public class BookSearchResult {

    @SerializedName("items") private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
