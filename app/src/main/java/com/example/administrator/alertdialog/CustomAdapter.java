package com.example.administrator.alertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class CustomAdapter extends BaseAdapter {

    private List<ItemBean> items;
    private LayoutInflater inflater;
    private ImageView      image;
    private TextView       text;

    public CustomAdapter(List<ItemBean> items, Context context) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_adapter, null);
            image = (ImageView) convertView.findViewById(R.id.id_image);
            text = (TextView) convertView.findViewById(R.id.id_text);
        }
        image.setImageResource(items.get(position).getImageId());
        text.setText(items.get(position).getMessage());
        return convertView;
    }
}
