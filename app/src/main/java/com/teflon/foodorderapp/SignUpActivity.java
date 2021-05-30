package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
EditText username,password, repassword;
Button signup,signin;
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        signup=(Button) findViewById(R.id.btnsignup);
        signin=(Button) findViewById(R.id.btnsignin);
        db=new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("")|| pass.equals("")||repass.equals("")){
                    Toast.makeText(SignUpActivity.this, "Please Enter all the Field", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean checkuser=db.checkusername(user);
                        if(checkuser==false){
                            Boolean insert=db.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this, "User Already exists! Please sign in", Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(SignUpActivity.this, "Passwords Not Matching", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}