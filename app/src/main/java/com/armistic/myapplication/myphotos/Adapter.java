package com.armistic.myapplication.myphotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.armistic.myapplication.R;
import com.armistic.myapplication.category.Category;

import java.util.List;

/**
 * Created by jibieta on 11-08-16.
 */
public class Adapter extends BaseAdapter {

    private Context context;
    private List<Photo> items;

    public Adapter(Context context, List<Photo> items) {
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

    static class ViewHolder {
        TextView category;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_my_photos_item, parent, false);

            viewHolder = new ViewHolder();

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Photo item = this.items.get(position);


        return convertView;

    }
}
