package com.leeway.simplemvp;

import com.leeway.simplemvp.model.Book;

import java.util.List;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public interface BooksView {
    void updateUi(List<Book> books);
}
