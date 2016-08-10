package com.armistic.myapplication.category;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.armistic.myapplication.R;

import java.util.List;

/**
 * Created by jibieta on 02-08-16.
 */
public class Adapter extends BaseAdapter {

    private Context context;
    private List<Category> items;

    public Adapter(Context context, List<Category> items) {
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
        TextView selected;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_async_category_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.category = (TextView) convertView.findViewById(R.id.id_category);
            viewHolder.selected = (TextView) convertView.findViewById(R.id.id_selected);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Category item = this.items.get(position);

        viewHolder.category.setText(item.getCategory());
        viewHolder.selected.setText(item.getSelected());

        return convertView;

    }
}
