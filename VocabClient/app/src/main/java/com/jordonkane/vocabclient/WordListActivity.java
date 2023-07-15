package com.jordonkane.vocabclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jordonkane.vocabclient.adapter.WordAdapter;
import com.jordonkane.vocabclient.model.Word;
import com.jordonkane.vocabclient.retrofit.RetrofitService;
import com.jordonkane.vocabclient.retrofit.WordAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        recyclerView = findViewById(R.id.wordList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.wordList_fab);
        floatingActionButton.setOnClickListener(view -> {

        });

        loadEmployees();
    }

    private void loadEmployees() {
        RetrofitService retrofitService = new RetrofitService();
        WordAPI wordAPI = retrofitService.getRetrofit().create(WordAPI.class);
        wordAPI.getAllWords().enqueue(new Callback<List<Word>>() {
            @Override
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Word>> call, Throwable t) {
                Toast.makeText(WordListActivity.this, "Failed to load words.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateListView(List<Word> wordList) {
        WordAdapter wordAdapter = new WordAdapter(wordList);
        recyclerView.setAdapter(wordAdapter);
    }
}