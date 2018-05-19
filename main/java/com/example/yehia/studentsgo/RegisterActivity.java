package com.example.yehia.studentsgo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yehia.studentsgo.com.example.yehia.studentsgo.beans.User;
import com.example.yehia.studentsgo.service.AsyncTaskUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends LoginActivity implements AdapterView.OnItemSelectedListener {

    private EditText user;
    private EditText pass_reg;
    private EditText conf_pass;
    private EditText name, surname;
    private EditText mail;
    private EditText Cell;
    private Spinner spinner1, spinner2, spinner3, spinner4;
    private String sp1, sp2, sp3, sp4, Email, Name, Sur, Pass, CellNum, BDay,c_pass;
    private RadioButton radioM, radioF, driver, pass;
    private Button buttonLoadImage, buttonCreateProfile;
    private ImageView imageView;
    private boolean Sex, profileStatus;
    private static int RESULT_LOAD_IMAGE = 10;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //Spinner and adapter for days
        spinner1 = findViewById(R.id.spinner_days);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.num_days, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //Spinner and adapter for months
        spinner2 = findViewById(R.id.spinner_months);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //Spinner and adapter for years
        spinner3 = findViewById(R.id.spinner_year);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        //Spinner and adapter for school
        spinner4 = findViewById(R.id.spinner_school);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.school, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        //Listener for loading image from gallery
        buttonLoadImage = findViewById(R.id.photo_button);
        imageView = findViewById(R.id.imgView);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        //user=findViewById(R.id.reg_username);
        pass_reg = findViewById(R.id.reg_password);
        name = findViewById(R.id.reg_name);
        surname = findViewById(R.id.reg_surname);
        conf_pass = findViewById(R.id.conf_password);
        mail = findViewById(R.id.reg_mail);
        radioM = findViewById(R.id.sex_m);
        radioF = findViewById(R.id.sex_f);
        driver = findViewById(R.id.driver);
        pass = findViewById(R.id.passenger);
        Cell = findViewById(R.id.reg_phone);
        conf_pass=findViewById(R.id.conf_password);

        buttonCreateProfile = findViewById(R.id.reg_button);
        buttonCreateProfile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp1 = spinner1.getSelectedItem().toString();
                sp2 = spinner2.getSelectedItem().toString();
                sp3 = spinner3.getSelectedItem().toString();
                sp4 = spinner4.getSelectedItem().toString();
                Email = mail.getText().toString();
                Name = name.getText().toString();
                Sur = surname.getText().toString();
                Pass = pass_reg.getText().toString();
                CellNum = Cell.getText().toString();
                c_pass=conf_pass.getText().toString();
                BDay = sp1 + " " + sp2 + " " + sp3;
                if (radioF.isChecked())
                    Sex = true;
                if (radioM.isChecked())
                    Sex = false;
                if (driver.isChecked())
                    profileStatus = true;
                if (pass.isChecked())
                    profileStatus = false;

                 if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Sur) && !TextUtils.isEmpty(Pass) && !TextUtils.isEmpty(CellNum) && !TextUtils.isEmpty(BDay)) {
                sendUser(Email, Name, Sur, Pass,c_pass ,CellNum, BDay, Sex, profileStatus);
                }
            }
        });


    }

    private void sendUser(String email, String name, String sur, String pass, String c_pass, String cellNum,  String BDay, boolean sex, boolean profileStatus) {
         User user = new User(name, sur, email, cellNum, sex, BDay, profileStatus,pass,c_pass);
        //User user = new User("Sandro", "Impastatinho", "s123@ndro.com", "123451111", false, null, true, "Pippo1!@", "Pippo1!@");
        AsyncTaskUser asyncTaskUser = new AsyncTaskUser();
        asyncTaskUser.setUser(user);
        asyncTaskUser.setFunction("createUser");
        try {
            User createdUser = (User) asyncTaskUser.execute().get();
            new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, Response<Response> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"Registraion successful",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {

                }

            };
        } catch (Exception e) {
            Log.e("STUDENTSGO", "Error", e);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {


            Uri selectedImage = data.getData();
            imageView.setImageURI(selectedImage);
        }


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.sex_m:
                if (checked)
                    radioF.setChecked(false);
                break;
            case R.id.sex_f:
                if (checked)
                    radioM.setChecked(false);
                break;
        }

        switch (view.getId()) {
            case R.id.driver:
                if (checked)
                    pass.setChecked(false);

                break;

            case R.id.passenger:
                if (checked)
                    driver.setChecked(false);

                break;

        }
    }

}