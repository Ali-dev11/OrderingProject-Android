package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.teflon.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}