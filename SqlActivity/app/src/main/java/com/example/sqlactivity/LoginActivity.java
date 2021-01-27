package com.example.sqlactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqlactivity.databinding.ActivityLoginBinding;
import com.example.sqlactivity.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());//inflates the view?
        setContentView(binding.getRoot());//getRoot method being important in viewBinding.

        dbHelper = new DBHelper(this); //intialize the database instance

        binding.etSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ////gets the username and password and converts them into string
                String username = binding.etUserName.getText().toString();
                String password = binding.etPassword.getText().toString();

                //If username or password are empty, Toast is generated
                if(username.equals("") || password.equals("")){
                    Toast.makeText(LoginActivity.this, "Empty", Toast.LENGTH_LONG).show();
                }
                else {

                    //checkUserPassword is a function in DBHelper.java class
                    boolean checkuserpass = dbHelper.checkUserPassword(username,password);
                    if (checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Sign In Success", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}