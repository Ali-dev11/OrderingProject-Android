package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnLogin,btnsignup;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        btnLogin=(Button)findViewById(R.id.btnsignin1);
        btnsignup=(Button)findViewById(R.id.btnsignup1);
        db=new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass=password.getText().toString();
                if (user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass=db.checkusernamepassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Username and Password is Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);

            }
        });


    }
}