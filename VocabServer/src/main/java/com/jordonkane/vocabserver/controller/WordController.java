package com.jordonkane.vocabserver.controller;

import com.jordonkane.vocabserver.model.word.Word;
import com.jordonkane.vocabserver.model.word.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {

    @Autowired
    private WordDAO wordDAO;

    @GetMapping("/word/get-all")
    public List<Word> getAllWords() {
        return wordDAO.getAllWords();
    }

    @PostMapping("/word/save")
    public Word save(@RequestBody Word word) {
        return wordDAO.save(word);
    }
}
