package com.example.leey_.level6;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "http://numbersapi.com/";


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /**
     * This get will get a random trivia output.
     */
    @GET("/random/?json&max=9999999")
    Call<TriviaNumber> getRandomQuoteAndNumber();
}
