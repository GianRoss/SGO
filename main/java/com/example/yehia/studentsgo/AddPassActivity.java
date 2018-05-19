package com.example.yehia.studentsgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddPassActivity extends AppCompatActivity {

    EditText ritrovoView;
    EditText cittaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pass);
        ritrovoView=findViewById(R.id.add_pass_ritrovo);
    }

    public void addNewPass(View view) {
        if(ritrovoView.getText().equals("")){



        }
    }
}
