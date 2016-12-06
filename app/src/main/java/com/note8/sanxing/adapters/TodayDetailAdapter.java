package com.note8.sanxing.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.note8.sanxing.R;

import java.util.ArrayList;

public class TodayDetailAdapter extends ArrayAdapter<String> {
    private int resourceId;

    public TodayDetailAdapter(Context context, int resource, ArrayList<String> data) {
        super(context, resource, data);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        String content = (String) getItem(position);
        TextView tv = (TextView) view.findViewById(R.id.td_listview_item);
        tv.setText(content);
        return view;
    }
}
