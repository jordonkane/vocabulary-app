package com.jordonkane.vocabclient;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.jordonkane.vocabclient.model.Word;
import com.jordonkane.vocabclient.retrofit.RetrofitService;
import com.jordonkane.vocabclient.retrofit.WordAPI;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    public void initializeComponents() {
        TextInputEditText inputEditTextWord = findViewById(R.id.form_textFieldWord);
        TextInputEditText inputEditTextDefinition = findViewById(R.id.form_textFieldWDefinition);
        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        WordAPI wordAPI = retrofitService.getRetrofit().create(WordAPI.class);

        buttonSave.setOnClickListener(view -> {
            String wordName = String.valueOf(inputEditTextWord.getText());
            String definition = String.valueOf(inputEditTextDefinition.getText());

            Word word = new Word();
            word.setWord(wordName);
            word.setDefinition(definition);

            wordAPI.save(word).enqueue(new Callback<Word>() {
                @Override
                public void onResponse(Call<Word> call, Response<Word> response) {
                    Toast.makeText(MainActivity.this, "Save Successful!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Word> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "An Error has occurred!", t);
                }
            });

        });
    }
}