package com.jordonkane.vocabserver;

import com.jordonkane.vocabserver.model.word.Word;
import com.jordonkane.vocabserver.model.word.WordDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VocabServerApplicationTests {

	// Dependency injection

	@Autowired
	private WordDAO wordDAO;

	/*
		List of test cases:
		1. Test for adding words
		2. Test for getting all words
		3. Test for deleting all words
	 */

	@Test
	void addWordTest() {
		Word word = new Word();
		word.setWord("testWord");
		word.setDefinition("Test definition.");
		wordDAO.save(word);
	}

	@Test
	void getAllWords() {
		List<Word> words = wordDAO.getAllWords();
		System.out.println(words);
	}

	@Test
	void deleteAllWordsTest() {
		List<Word> words = wordDAO.getAllWords();
		for (Word word : words) {
			wordDAO.delete(word);
		}
	}

}
