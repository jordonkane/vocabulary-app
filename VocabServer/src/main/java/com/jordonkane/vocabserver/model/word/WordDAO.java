package com.jordonkane.vocabserver.model.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordDAO {

    @Autowired
    private WordRepository repository;

    public Word save(Word word) {
        return repository.save(word);
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        Streamable.of(repository.findAll())
            .forEach(words::add);
        return words;
    }

    public void delete(Word word) {
        repository.delete(word);
    }

}
