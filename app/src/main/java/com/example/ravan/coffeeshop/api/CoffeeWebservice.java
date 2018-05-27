package com.example.ravan.coffeeshop.api;

import com.example.ravan.coffeeshop.api.response.ApiResponse;

import java.util.concurrent.Callable;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoffeeWebservice {
    @GET("/v1/search-items")
    Single<ApiResponse> getSearchItems();
}
