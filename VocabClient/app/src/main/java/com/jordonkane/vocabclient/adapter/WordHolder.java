package com.jordonkane.vocabclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jordonkane.vocabclient.R;

public class WordHolder extends RecyclerView.ViewHolder {

    TextView word, definition;

    public WordHolder(@NonNull View itemView) {
        super(itemView);
        word = itemView.findViewById(R.id.wordListItem_word);
        definition = itemView.findViewById(R.id.wordListItem_definition);

    }
}
