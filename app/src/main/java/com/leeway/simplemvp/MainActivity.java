package com.leeway.simplemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.leeway.simplemvp.manager.GoogleBookService;
import com.leeway.simplemvp.model.Book;
import com.leeway.simplemvp.model.BookSearchResult;
import com.leeway.simplemvp.model.BooksInteractor;
import com.leeway.simplemvp.model.BooksInteractorImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements BooksView{

    EditText editText;
    Button btnSearch;
    TextView textNoDataFound;

    BooksInteractor interactor;
    BooksPresenter presenter;

    BooksAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        // Note: Don't do this on production code, use Dependency Injection instead
        // to provide the BooksInteractor and the BooksPresenter to the View
        interactor = new BooksInteractorImpl();
        presenter = new BooksPresenter(interactor);
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
