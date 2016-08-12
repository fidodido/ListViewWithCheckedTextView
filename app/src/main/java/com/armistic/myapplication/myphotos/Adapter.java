package com.armistic.myapplication.myphotos;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageView photo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_my_photos_item, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Photo item = this.items.get(position);

        viewHolder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(view.getContext());

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.setContentView(R.layout.activity_my_photos_dialog);
                ImageView image = (ImageView) dialog.findViewById(R.id.my_image);
                image.setImageResource(R.drawable.profile);

                dialog.show();

            }
        });


        return convertView;

    }
}
