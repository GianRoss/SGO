package com.example.yehia.studentsgo.service;

import android.os.AsyncTask;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;

import java.io.IOException;

import okhttp3.Response;

public class AsyncTaskUser extends AsyncTask<Void, Void, Object> {

    private Integer id;
    private String function;
    private User user;
    @Override
    protected Object doInBackground(Void... voids) {
        try {
            //return ServiceProvider.getService().listUsers().execute().body();
            StudentsgoService service = ServiceProvider.getService();

            switch(function) {
                case "getUser":
                    return service.getUser(id).execute().body();
                /*case "updateUser":
                     Object obj = service.updateUser(id, user).execute().body();
                    return obj;
                    */
                case "createUser" :
                    Response res = service.saveUser(user).execute().raw();
                    return res;
                    // return service.saveUser(user).execute().body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setFunction(String function) {
        this.function = function;
    }
}