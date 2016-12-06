package com.note8.sanxing.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.note8.sanxing.R;
import com.note8.sanxing.items.BDListViewItem;

import java.util.LinkedList;

public class BDListViewAdapter extends BaseAdapter {
    private Context context = null;
    private LinkedList<BDListViewItem> list = null;

    public BDListViewAdapter(Context c, LinkedList<BDListViewItem> l) {
        this.context = c;
        this.list = l;
    }

    @Override
    public int getCount() {
        if (this.list == null)
            return 0;
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        if (this.list == null || this.list.size() <= i)
            return null;
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.broadcast_detail_item, null);
        }
        BDListViewItem item = this.list.get(i);
        ImageView avatar = (ImageView) view.findViewById(R.id.bd_item_avatar);
        avatar.setImageResource(item.getUserAvatarRes());
        TextView userName = (TextView) view.findViewById(R.id.bd_item_username);
        userName.setText(item.getUsername());
        TextView infoView = (TextView) view.findViewById(R.id.bd_item_info);
        infoView.setText(item.getInfo());
        TextView contentView = (TextView) view.findViewById(R.id.bd_item_content);
        contentView.setText(item.getContent());
        return view;
    }
}
