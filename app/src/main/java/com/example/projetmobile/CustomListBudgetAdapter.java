package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListBudgetAdapter extends BaseAdapter {
    private List<Transaction> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListBudgetAdapter(Context aContext, List<Transaction> listData) {
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
        CustomListBudgetAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_budget_custom_list, null);
            holder = new CustomListBudgetAdapter.ViewHolder();
            holder.Nom = (TextView) convertView.findViewById(R.id.nom);
            holder.Etat = (TextView) convertView.findViewById(R.id.etat);
            holder.Montant = (TextView) convertView.findViewById(R.id.montant);
            convertView.setTag(holder);
        } else {
            holder = (CustomListBudgetAdapter.ViewHolder) convertView.getTag();
        }

        Transaction transaction = this.listData.get(position);
        holder.Nom.setText(transaction.getNom());
        holder.Etat.setText(transaction.getType());
        holder.Montant.setText(transaction.getMontant());
        return convertView;
    }

    static class ViewHolder {
        TextView Nom;
        TextView Etat;
        TextView Montant;
    }
}
