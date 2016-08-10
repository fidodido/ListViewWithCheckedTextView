package com.armistic.myapplication.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.armistic.myapplication.R;

import java.util.List;

/**
 * Created by jibieta on 05-08-16.
 */
public class Adapter extends BaseAdapter {

    public static String TAG = "Adapter";

    private Context context;
    private List<Item> items;

    public Adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_async_select_item, parent, false);
        }

        CheckedTextView checkedTextView = (CheckedTextView) convertView.findViewById(R.id.checkedTextView1);
        final Item item = items.get(position);
        checkedTextView.setText(item.getTitle());

        return convertView;

    }

}

