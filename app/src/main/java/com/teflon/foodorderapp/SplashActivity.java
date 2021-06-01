package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
TextView textView;
Animation fadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
textView=findViewById(R.id.spText);

fadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

textView.setVisibility(View.VISIBLE);
textView.startAnimation(fadein);





        Thread td=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent );
                }
            }

        }; td.start();

    }
}