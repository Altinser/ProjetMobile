package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListNoteAdapter extends BaseAdapter {
    private List<Note> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListNoteAdapter(Context aContext, List<Note> listData) {
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
        CustomListNoteAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_note_custom_list, null);
            holder = new CustomListNoteAdapter.ViewHolder();
            holder.not = (TextView) convertView.findViewById(R.id.not);
            convertView.setTag(holder);
        } else {
            holder = (CustomListNoteAdapter.ViewHolder) convertView.getTag();
        }

        Note note = this.listData.get(position);
        holder.not.setText(note.getNote());
        return convertView;
    }

    static class ViewHolder {
        TextView not;
    }
}
