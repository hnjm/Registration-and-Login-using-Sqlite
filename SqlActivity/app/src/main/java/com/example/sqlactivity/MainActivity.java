package com.example.sqlactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.example.sqlactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());//inflates the view?
        setContentView(binding.getRoot());//getRoot method being important in viewBinding.

        dbHelper = new DBHelper(this);

        binding.etSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.etSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.etUserName.getText().toString();
                String password = binding.etPassword.getText().toString();
                String repassword = binding.etRepass.getText().toString();

                if (username.equals("") || password.equals("") || repassword.equals("")){
                    Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_LONG).show();
                }
                else {
                    if(password.equals(repassword)){
                        Boolean checkuser = dbHelper.checkUserName(username);
                        if(checkuser == false) {
                            boolean insert = dbHelper.insertData(username, password);

                            if (insert == true){
                                Toast.makeText(MainActivity.this, "Registered!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "FAIL!", Toast.LENGTH_LONG).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Password not matching!", Toast.LENGTH_LONG).show();

                    }
                }


            }
        });
    }
}