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

public class TruyenAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TruyenActivity> listTruyen;

    //constructor

    public TruyenAdapter(Context context, ArrayList<TruyenActivity> listTruyen) {
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
    public class MyViewHodel{
        TextView txtTenTruyen;
        ImageView imageTruyen;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHodel myViewHodel = null;
        myViewHodel = new MyViewHodel();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.truyenhay, null);
        myViewHodel.txtTenTruyen = convertView.findViewById(R.id.texttruyenhay);
        myViewHodel.imageTruyen = convertView.findViewById(R.id.imagetruyenhay);
        convertView.setTag(myViewHodel);

        TruyenActivity truyen = (TruyenActivity) getItem(position);
        myViewHodel.txtTenTruyen.setText(truyen.getTenTruyen());

        Picasso.get().load(truyen.getAnh()).placeholder(R.drawable.ic_load)
                .error(R.drawable.ic_image)
                .into(myViewHodel.imageTruyen);
        return convertView;
    }
}


