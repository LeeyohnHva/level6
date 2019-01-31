package com.example.leey_.level6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<TriviaNumber> trivias;
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recyclerViewTrivia);
        trivias = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TriviaNumberAdapter(trivias);
        mRecyclerView.setAdapter(mAdapter);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData(); }
        });

    }

    private void requestData() {
        ApiService service = ApiService.retrofit.create(ApiService.class);
        retrofit2.Call<TriviaNumber> call = service.getRandomQuoteAndNumber();
        call.enqueue(new Callback<TriviaNumber>() {
            @Override
            public void onResponse(Call<TriviaNumber> call, Response<TriviaNumber> response) {
                TriviaNumber numberItem = response.body();
                trivias.add(0,new TriviaNumber(numberItem.getText(), numberItem.getNumber()));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TriviaNumber> call, Throwable t) {
            }

        });
    }
}
