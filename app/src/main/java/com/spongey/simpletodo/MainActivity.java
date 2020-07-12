package com.spongey.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> items;

    // References to the views in the main activity

    Button addButton;
    EditText editItem;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaration of the items in the main layout
        addButton = findViewById(R.id.addButton);
        editItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);


        items = new ArrayList<>();
        items.add("Buy milk");
        items.add("Go to the gym");
        items.add("Do the morning dishes");
        items.add("Have fun");

        ItemsAdapter itemsAdapter = new ItemsAdapter(items);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
    }
}
