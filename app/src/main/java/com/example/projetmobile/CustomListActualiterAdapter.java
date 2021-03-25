package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListActualiterAdapter extends BaseAdapter {

    private List<Actualiter> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListActualiterAdapter(Context aContext, List<Actualiter> listData) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_actualiter_custom_list, null);
            holder = new ViewHolder();
            holder.Actu = (TextView) convertView.findViewById(R.id.Actu);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Actualiter actualiter = this.listData.get(position);
        holder.Actu.setText(actualiter.getActu());
        return convertView;
    }

    static class ViewHolder {
        TextView Actu;
    }
}