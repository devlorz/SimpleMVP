package com.leeway.simplemvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.leeway.simplemvp.App;
import com.leeway.simplemvp.R;
import com.leeway.simplemvp.data.manager.GoogleBookService;
import com.leeway.simplemvp.data.model.Book;
import com.leeway.simplemvp.data.model.BooksInteractor;
import com.leeway.simplemvp.data.model.BooksInteractorImpl;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements BooksView{

    EditText editText;
    Button btnSearch;
    TextView textNoDataFound;

    BooksPresenter presenter;

    BooksAdapter adapter;
    ListView listView;

    @Inject
    public void setPresenter(BooksPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        ((App) getApplication()).getAppComponent().inject(this);
        presenter.bind(this);

        adapter = new BooksAdapter(this, -1);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.performSearch(getUserInput());
            }
        });
    }

    private void initInstances() {
        editText = (EditText) findViewById(R.id.editText);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        textNoDataFound = (TextView) findViewById(R.id.textNoDataFound);
    }

    public void updateUi(List<Book> books) {
        if(books.isEmpty()) {
            textNoDataFound.setVisibility(View.VISIBLE);
        } else {
            textNoDataFound.setVisibility(View.GONE);
        }
        adapter.clear();
        adapter.addAll(books);
    }

    private String getUserInput() {
            return editText.getText().toString();
    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
