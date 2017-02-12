package com.leeway.simplemvp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leeway.simplemvp.R;
import com.leeway.simplemvp.data.model.Book;

/**
 * Created by Lee Lorz on 2/11/2017.
 */

public class BooksAdapter extends ArrayAdapter<Book> {

    public BooksAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
        if (book.getVolumeInfo() != null) {
            tvTitle.setText(book.getVolumeInfo().getTitle());
            if (book.getVolumeInfo().getAuthor() != null) {
                StringBuilder builder = new StringBuilder();
                for (String authorName :
                        book.getVolumeInfo().getAuthor()) {
                    if (builder.length() > 0) {
                        builder.append(", ");
                    }
                    builder.append(authorName);
                }
                tvAuthor.setText(builder.toString());
            }
        }

        return convertView;
    }
}
