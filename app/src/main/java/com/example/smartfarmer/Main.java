package com.example.smartfarmer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    public String[] namesP = {"Сгущенка","Молоко","Кефир","Сыр","Йогурт клубничный","Йогурт банановый"};
    public String[] descriptionP = {"",
            "",
            "Самый распространенный кисломолочный продукт, получаемый из коровьего молока путем воздействия на него целого комплекса бактерий. Всего их насчитывается около двух десятков, но больше всего в этом комплексе, называемом «кефирным грибком», содержится дрожжевых, уксуснокислых бактерий и молочнокислых палочек.",
            "",
            "",
            ""};
    public String[] pricesP = {"189 ₽","199 ₽","129 ₽","389 ₽","79 ₽","79 ₽"};
    public int[] imagesP = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
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


        productList.add(new Product(imagesP[0], namesP[0], pricesP[0],"Поставщик"));
        productList.add(new Product(imagesP[1], namesP[1], pricesP[1],"Поставщик"));
        productList.add(new Product(imagesP[2], namesP[2], pricesP[2],"Поставщик"));
        productList.add(new Product(imagesP[3], namesP[3], pricesP[3],"Поставщик"));
        productList.add(new Product(imagesP[4], namesP[4], pricesP[4],"Поставщик"));
        productList.add(new Product(imagesP[5], namesP[5], pricesP[5],"Поставщик"));

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                int selectedPosition = position;

                Intent intent = new Intent(Main.this, ProductProfile.class);

                intent.putExtra("selected_item",selectedItem);
                intent.putExtra("selectedPosition",selectedPosition);
                startActivity(intent);
            }
        });
    }
}