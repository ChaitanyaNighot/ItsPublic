package com.example.chaitnya.abcd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button b1;
    Context context;
    abcdAdapter adapter;
    String name[] = {"A paratha with dahi and pickle and some cold drink","B paratha","C paratha","D paratha"};
    String fee[] ={"50","50","50","50"};
    String halffee[]={"25","25","0","25"};
    String desc[]={"daahi wala paratha","delicious oily paratha will increase your fats","khaate jao aur mota ho jao","tasty paratha"};
    int image[] = {R.drawable.food1,R.drawable.food1,R.drawable.food1,R.drawable.food1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rec_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new abcdAdapter(name,fee,image,halffee,desc,this);
        recyclerView.setAdapter(adapter);


    }
}
