package com.example.picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapterRoom extends BaseAdapter {
    Context cntx;
    List<FullProduct> products;

    ProductAdapterRoom(Context cntx, List<FullProduct> products){
        this.cntx = cntx;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FullProduct product = products.get(position);
        convertView = LayoutInflater.from(cntx).inflate(R.layout.productitem, parent, false);

        TextView name = convertView.findViewById(R.id.name);
        name.setText(product.product.name);

        return null;
    }
}

