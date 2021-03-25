package com.example.picasso;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductAdapter extends CursorAdapter {
    Picasso p;
    public ProductAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        p  = new Picasso.Builder(context).build();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.productitem, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView picture = view.findViewById(R.id.picture);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvPrice = view.findViewById(R.id.price);
        TextView tvAuthor = view.findViewById(R.id.author);

        String name = cursor.getString(cursor.getColumnIndex("name"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));
        String url = cursor.getString(cursor.getColumnIndex("url"));
        String author = cursor.getString(cursor.getColumnIndex("author"));

        tvName.setText(name);
        tvAuthor.setText(author);
        tvPrice.setText(Integer.toString(price));
        Picasso.get().load(url).into(picture);
    }
}