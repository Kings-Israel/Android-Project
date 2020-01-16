package com.example.mydatabaseproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends CursorAdapter {
    private LayoutInflater cursorInflator;

    public listAdapter(Context context, Cursor c) {
        super(context, c);
        cursorInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.detail_adapter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextVeiw = (TextView) view.findViewById(R.id.textView);
        String name = cursor.getString(cursor.getColumnIndex("StudentName"));
        nameTextVeiw.setText(name);
    }
}
