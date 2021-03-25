package com.example.picasso;

import java.util.List;

public class FullProduct {
    Product product;
    List<Category> categories;

    FullProduct(Product p, List<Category> c){
        this.categories = c;
        this.product = p;
    }
}
