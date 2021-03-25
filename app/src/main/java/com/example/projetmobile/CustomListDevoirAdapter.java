package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListDevoirAdapter extends BaseAdapter {
    private List<Devoir> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListDevoirAdapter(Context aContext, List<Devoir> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CustomListDevoirAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_devoir_custom_list, null);
            holder = new CustomListDevoirAdapter.ViewHolder();
            holder.Dev = (TextView) convertView.findViewById(R.id.dev);
            convertView.setTag(holder);
        } else {
            holder = (CustomListDevoirAdapter.ViewHolder) convertView.getTag();
        }

        Devoir devoir = this.listData.get(position);
        holder.Dev.setText(devoir.getDevoir());
        return convertView;
    }

    static class ViewHolder {
        TextView Dev;
    }
}
