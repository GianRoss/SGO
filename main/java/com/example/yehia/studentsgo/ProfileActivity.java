package com.example.yehia.studentsgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView ProfileName;
    TextView ProfileEmail;
    TextView ProfileLicense;
    TextView ProfileCity;
    TextView ProfileSchool;
    TextView ProfileYear;
    String email,name,city,school,year,license;

    boolean patente;

    int giorno,mese,anno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ProfileName = findViewById(R.id.profile_name);
        ProfileYear = findViewById(R.id.profile_year);
        ProfileEmail = findViewById(R.id.profile_email);
        ProfileLicense = findViewById(R.id.profile_license);
        ProfileCity = findViewById(R.id.profile_city);
        ProfileSchool = findViewById(R.id.profile_school);

        name="Esempio Utente";
        email="example@gmail.com";
        city="Milano";
        school="//";

        year=giorno+"/"+mese+"/"+anno;

        if(patente==true){

            license="Si";

        }
        else{

            license="No";

        }


        ProfileName.setText(name);
        ProfileEmail.setText(" Email: "+email);
        ProfileYear.setText(" Data di nascita: "+year);
        ProfileSchool.setText(" Scuola: "+school);
        ProfileCity.setText(" Residente a: " +city);
        ProfileLicense.setText(" Patentato: "+license);

    }


    public void Modify(View view) {

        Intent intent = new Intent(this, ModifyProfileActivity.class);
        startActivity(intent);

    }

    public void Logout(View view) {
        SharedPreferences shPreference= getSharedPreferences(LoginActivity.APP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shPreference.edit().remove(LoginActivity.Username_key);
        editor.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
