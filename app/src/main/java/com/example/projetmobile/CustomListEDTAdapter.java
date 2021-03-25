package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListEDTAdapter extends BaseAdapter {

    private List<Cour> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListEDTAdapter(Context aContext, List<Cour> listData) {
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
            convertView = layoutInflater.inflate(R.layout.activity_e_d_t_custom_list, null);
            holder = new ViewHolder();
            holder.NomView = (TextView) convertView.findViewById(R.id.NomCour);
            holder.NumView = (TextView) convertView.findViewById(R.id.Actu);
            holder.NomProfView = (TextView) convertView.findViewById(R.id.NomProf);
            holder.Horraire = (TextView) convertView.findViewById(R.id.Horraire);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cour cour = this.listData.get(position);
        holder.NomView.setText("Cour de : "+cour.getNom());
        holder.NumView.setText("Salle : "+cour.getSalle());
        holder.NomProfView.setText("Avec : "+cour.getProfesseur());
        holder.Horraire.setText(cour.getHorraire());
        return convertView;
    }




    static class ViewHolder {
        TextView NomView;
        TextView NumView;
        TextView NomProfView;
        TextView Horraire;
    }
}