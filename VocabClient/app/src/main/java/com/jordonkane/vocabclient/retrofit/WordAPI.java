package com.jordonkane.vocabclient.retrofit;

import com.jordonkane.vocabclient.model.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WordAPI {

    @GET("/word/get-all")
    Call<List<Word>> getAllWords();

    @POST("/word/save")
    Call<Word> save(@Body Word word);

}
