package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class affichage extends BaseAdapter {

    private List<evenement> listData;
    private LayoutInflater layoutInflater;

    public affichage(Context aContext,  List<evenement> listData) {
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
            convertView = layoutInflater.inflate(R.layout.transaction, null);
            holder = new ViewHolder();
            holder.transacNom = convertView.findViewById(R.id.name_transac);
            holder.transacType = convertView.findViewById(R.id.type_transac);
            holder.transacMont = convertView.findViewById(R.id.montant_transac);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        evenement evenement = this.listData.get(position);

        holder.transacNom.setText(evenement.getNom());
        holder.transacType.setText(evenement.getType());
        holder.transacMont.setText(evenement.getMontant());

        return convertView;
    }

    static class ViewHolder {
        TextView transacNom;
        TextView transacType;
        TextView transacMont;
    }
}
