package com.leeway.simplemvp.ui;

import com.leeway.simplemvp.data.model.Book;

import java.util.List;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public interface BooksView {
    void updateUi(List<Book> books);
}
