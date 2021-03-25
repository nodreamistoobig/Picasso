package com.example.picasso;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey
    @NonNull
    int _id;
    @NonNull
    String name, author, url;
    @NonNull
    float price;

    public Product(int _id, @NonNull String name, @NonNull String author, float price, @NonNull String url) {
        this._id = _id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.url = url;
    }
}