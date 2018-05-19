package com.example.yehia.studentsgo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterCarActivity extends AppCompatActivity {


        private Button buttonCarLoadImage;
        private ImageView imageView1;
        private int RESULT_LOAD_IMAGE = 10;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_car);
            buttonCarLoadImage = findViewById(R.id.car_button);
            imageView1 = findViewById(R.id.imgView1);
            buttonCarLoadImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    Intent i = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, RESULT_LOAD_IMAGE);
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {


                Uri selectedImage = data.getData();
                imageView1.setImageURI(selectedImage);
            }

        }

        public void finishCreate(View view) {

        }


    }
