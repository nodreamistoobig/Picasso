package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DB db;
    DBHelper helper;
    List<Product> products_list;
    List<FullProduct> full_products_list;
    ListView products_view;
    SQLiteDatabase sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products_view = findViewById(R.id.products_list);

        helper = new DBHelper(this);
        sqlite = helper.getWritableDatabase();
        Cursor c = sqlite.rawQuery("SELECT * FROM products", null);
        Log.d("TAG", String.valueOf(c.getCount()));
        ProductAdapter ad = new ProductAdapter(this, c, 0);
        products_view.setAdapter(ad);

        /*db = DB.create(this, false);
        new Thread() {
            @Override
            public void run() {
                products_list = db.manager().selectAllProd();
                Log.d("MYTAG", String.valueOf(products_list.size()));
                //setCursorInUIThread(products_list);
            }
        }.start();*/
    }

    public void setCursorInUIThread(List<Product> products_list) {
        Context cntx = getApplicationContext();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (products_list.size() > 0) {
                    for (Product product : products_list) {
                        List<Category> categories = db.manager().selectProductCategories(product._id);
                        full_products_list.add(new FullProduct(product, categories));
                        Log.d("MYTAG", full_products_list.get(0).product.name);
                    }
                    ProductAdapterRoom adapter = new ProductAdapterRoom(cntx, full_products_list);
                    products_view.setAdapter(adapter);
                }
            }
        });
    }

}