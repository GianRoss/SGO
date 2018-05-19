package com.example.yehia.studentsgo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    private static final StudentsgoService service;

    public static Retrofit retrofit = null;

  /*  public static Retrofit getClient(String baseURL) {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://studentsgo.streetgorilla.it/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }*/


    static {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://studentsgo.streetgorilla.it/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(StudentsgoService.class);
    }

    /**
     * @return Get the service.
     */
    public static StudentsgoService getService() {
        return service;
    }
}
