package com.example.smartfarmer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private SearchView searchView;
    private ListView listView;
    //a List of type hero for holding list items
    List<Product> productList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        ///
        productList = new ArrayList<>();

        //adding some values to our list
        productList.add(new Product(R.drawable.image1, "Spiderman", "188","Поставщик"));
        productList.add(new Product(R.drawable.image2, "Joker", "222","Поставщик"));
        productList.add(new Product(R.drawable.image3, "Iron Man", "3223","Поставщик"));
        productList.add(new Product(R.drawable.image4, "Doctor Strange", "234","Поставщик"));
        productList.add(new Product(R.drawable.image5, "Captain America", "11","Поставщик"));
        productList.add(new Product(R.drawable.image6, "Batman", "919","Поставщик"));

        //creating the adapter
        MyListAdapter adapter = new MyListAdapter(this, R.layout.list_item, productList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
        ///

    }
}