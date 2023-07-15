package com.jordonkane.vocabclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jordonkane.vocabclient.R;
import com.jordonkane.vocabclient.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordHolder> {

    private List<Word> wordList;

    public WordAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_word_item, parent, false);
        return new WordHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, int position) {
        Word word = wordList.get(position);
        holder.word.setText(word.getWord());
        holder.definition.setText(word.getDefinition());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }
}
