package com.example.alphademo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.alphademo.database.DatabaseSQLite;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    Button login;
    EditText username, password;
    DatabaseSQLite myDB = new DatabaseSQLite(this);


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);

        username = findViewById(R.id.Driverid);
        password = findViewById(R.id.password);

        onClickLogin();


    }
    private void onClickLogin() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("") && password.getText().toString().equals("")){

                    openActivity2();
                }
                else{
                    showMessage("Message", "Error Logging In!");
                }


            }
        });
    }

    /**
     * This method opens new activity when login button is pressed
     */
    public void openActivity2(){

            Intent intent= new Intent(this, MainActivity2.class);
            startActivity(intent);
        /**
         * animation for the login button
         */
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        Bounce interpolator = new Bounce(0.2, 30);
        myAnim.setInterpolator(interpolator);
        login.startAnimation(myAnim);
        }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
