package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.adapter.ItemAdapter;
import com.example.test.model.Item;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("삼성전자", "2021-01-01", 80000, 10, 85000));
        itemList.add(new Item("LG전자", "2021-01-01", 160000, 5, 170000));
        itemList.add(new Item("SK하이닉스", "2021-01-01", 120000, 8, 130000));
        itemList.add(new Item("NAVER", "2021-01-01", 300000, 3, 320000));
        itemList.add(new Item("카카오", "2021-01-01", 400000, 2, 420000));

        for(int i = 0; i < 50; i++){
            itemList.add(new Item("test", "2021-01-01", 80000, 10, 85000));
        }

        //find RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(itemList));

        //find ActivityView
        TextView activityView = findViewById(R.id.ActivityView);
        activityView.setText("메인화면입니다.");

        //find Button
        Button addButton = findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddItemActivity();
            }
        });
    }

    private void openAddItemActivity(){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }



}