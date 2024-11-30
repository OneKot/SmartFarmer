package com.example.smartfarmer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

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
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private TextView textView2;
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
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        textView2 = findViewById(R.id.textView2);
        productList = new ArrayList<>();

        //adding some values to our list
        productList.add(new Product(R.drawable.image1, "Сгущенка", "189 ₽","Поставщик"));
        productList.add(new Product(R.drawable.image2, "Молоко", "199 ₽","Поставщик"));
        productList.add(new Product(R.drawable.image3, "Кефир", "129 ₽","Поставщик"));
        productList.add(new Product(R.drawable.image4, "Сыр", "389 ₽","Поставщик"));
        productList.add(new Product(R.drawable.image5, "Йогурт клубничный", "79 ₽","Поставщик"));
        productList.add(new Product(R.drawable.image6, "Йогурт банановый", "79 ₽","Поставщик"));

        //creating the adapter
        MyListAdapter adapter = new MyListAdapter(this, R.layout.list_item, productList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,MilkPage.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,MeatPage.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,TechPage.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ServicesPage.class);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}