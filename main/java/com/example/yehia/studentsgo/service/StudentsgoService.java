package com.example.yehia.studentsgo.service;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StudentsgoService {
    @GET("users")
    Call<List<User>> listUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") int id);

    @POST("users")
    @FormUrlEncoded
    @Headers("X-Requested-With: XMLHttpRequest")
    Call<User> saveUser(@Body User user);
}
