package com.teflon.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.teflon.foodorderapp.Adapters.OrdersAdapter;
import com.teflon.foodorderapp.Models.OrdersModel;
import com.teflon.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    binding=ActivityOrderBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
       /* ArrayList<OrdersModel> list =new ArrayList<>();*/
        /*list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","4","65464"));*/

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list =helper.getOrders();

        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}