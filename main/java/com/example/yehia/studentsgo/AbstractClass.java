package com.example.yehia.studentsgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class AbstractClass extends AppCompatActivity {
    LoginActivity tmp= new LoginActivity();
    //static final int REQUEST_IMAGE_CAPTURE=1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.profile:
                Intent inten = new Intent(this, ProfileActivity.class);
                startActivity(inten);
                //finish();
                break;
        }
        return true;
    }

}
