package com.example.yehia.studentsgo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;
import com.example.yehia.studentsgo.service.ServiceProvider;

import java.io.IOException;
import java.util.List;

import static com.example.yehia.studentsgo.service.ServiceProvider.getService;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameView;
    private EditText passwordView;
    public static final String APP_NAME = "com.example.yehia.studentsgo.STUDENTSGO";
    public static final String Username_key = "Yehia";
    public static final String Password_key = "123";
    //public static final String Contatore_key = "0";
    public static SharedPreferences sharedPreferences;
    private ImageView toggleImg;
    public static boolean verWelcToast;
    protected ArrayList<User> arrayUser= new ArrayList<User>();
    protected Intent intentHome = new Intent(this, HomeActivity.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        arrayUser.add(new User(Username_key,Password_key));
        verWelcToast=false;
       // sharedPreferences = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
        usernameView= findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        toggleImg= findViewById(R.id.toggle_img);
        
        for(int i=0;i<arrayUser.size();i++){
            if(arrayUser.get(i).getName().equals(usernameView.getText().toString())&&arrayUser.get(i).getPassword().equals(passwordView.getText().toString()))   
                startActivity(intentHome);
        }

      /*  if(sharedPreferences.contains(Username_key)){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            usernameView= findViewById(R.id.username);
            passwordView = findViewById(R.id.password);
        }*/

        //findViewById(R.id.)
    }

    @Override
    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.Confirm);
        builder.setMessage(R.string.are_you_sure);

        builder.setPositiveButton(R.string.Yes , new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                finish();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    public void Login(View view) {
        String password = passwordView.getText().toString();
        String username = ((EditText) usernameView).getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Log.d("App_1", username);
        Log.d("App_2", password);

        if(password.equals(Password_key) && username.equals(Username_key)){
            editor.putString(Username_key, username);
            editor.putString(Password_key, password);
            //editor.putInt(Contatore_key,HomeActivity.contatore);
            editor.commit();
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra(Username_key, ((EditText) usernameView).getText().toString());
            intent.putExtra(Password_key, passwordView.getText().toString());
            startActivity(intent);
            finish();


        } else{
            Toast.makeText(this, "Credenziali Errate, Riprova.", Toast.LENGTH_SHORT).show();
        }

    }

    public void PasswordVisibility(View view) {
        if (passwordView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            passwordView.setTransformationMethod(null);
            toggleImg.setImageResource(R.drawable.ic_visibility_off_black_24dp);


        } else {
            passwordView.setTransformationMethod(new PasswordTransformationMethod());
            toggleImg.setImageResource(R.drawable.ic_visibility_black_24dp);
        }
    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
