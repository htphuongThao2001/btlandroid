package com.example.truyenchu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.truyenchu.R;
import com.example.truyenchu.activity.TruyenActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruyenctnnAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TruyenActivity> listTruyen;

    public TruyenctnnAdapter(Context context, ArrayList<TruyenActivity> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder{
        TextView txtTenTruyen;
        ImageView imgtruyen;
    }

    public void sortTruyenctnn (String s) {
        s = s.toUpperCase();
        int k=0;
        for (int i=0; i<listTruyen.size();i++) {
            TruyenActivity t = listTruyen.get(i);
            String ten = t.getTenTruyen().toUpperCase();
            if (ten.indexOf(s)>=0) {
                listTruyen.set(i, listTruyen.get(k));
                listTruyen.set(k,t);
                k++;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder= null;
        viewHolder = new MyViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.truyen_item, null);

        viewHolder.txtTenTruyen = convertView.findViewById(R.id.textviewtruyenitem);
        viewHolder.imgtruyen = convertView.findViewById(R.id.imagetruyenitem);
        convertView.setTag(viewHolder);

        TruyenActivity truyen = (TruyenActivity) getItem(position);
        viewHolder.txtTenTruyen.setText(truyen.getTenTruyen());

        Picasso.get().load(truyen.getAnh())
                .placeholder(R.drawable.ic_load)
                .error(R.drawable.ic_image)
                .into(viewHolder.imgtruyen);

        return convertView;
    }

}