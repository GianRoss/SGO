package com.example.yehia.studentsgo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PassagesService {
    //@Headers("X-API-Key: 2eed2020")
    @GET("product_app.json")
    Call<List<Object>> listProducts();
}
