package com.example.yehia.studentsgo.service;

import android.os.AsyncTask;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;

import java.io.IOException;
import java.util.List;

public class AsyncTaskTest  extends AsyncTask<Void, Void, List<User>>{
    @Override
    protected List<User> doInBackground(Void... voids) {
        try {
            return ServiceProvider.getService().listUsers().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
