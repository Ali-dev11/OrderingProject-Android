package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.teflon.foodorderapp.Adapters.MainAdapter;
import com.teflon.foodorderapp.Models.MainModel;
import com.teflon.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list =new ArrayList<>();
        list.add(new MainModel(R.drawable.burger,"Burger","5","Chicken Burger With extra cheese"));
        list.add(new MainModel(R.drawable.burger1,"Burger Again","15","Beef Burger With extra cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","25","Chicken Pizza With extra Topping"));
        list.add(new MainModel(R.drawable.burger,"Burger","2","haha Burger With extra chicken"));
        list.add(new MainModel(R.drawable.burger,"Burger","17","heheheh Burger With extra cheese"));
        list.add(new MainModel(R.drawable.burger,"Burger","17","whattth Burger With extra cheese"));

        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);



    }
}