package com.toumal.blogblog;

import com.toumal.blogblog.Model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitNetworkInterface {
    @GET("sohel-cse/simple-blog-api/db")
    Call<JSONResponse> allBlogs();
}
