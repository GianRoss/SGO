package com.example.yehia.studentsgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ModifyProfileActivity extends AppCompatActivity {
    EditText Password;
    EditText City;
    EditText Email;
    EditText School;
    EditText Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);
    }
    public void ConfirmPassword(View view) {
    }

    public void ConfirmData(View view) {
    }
}
