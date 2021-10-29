package com.example.truyenchu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.truyenchu.R;
import com.example.truyenchu.adapter.TruyenctnnAdapter;
import com.example.truyenchu.database.databasedoctruyen;

import java.util.ArrayList;

public class TruyenNguNgonActivity extends AppCompatActivity {
    ImageButton btnbackTNN;
    ListView listView;
    EditText edt;
    ArrayList<TruyenActivity> TruyenArrayList;

    ArrayList<TruyenActivity> arrayList;
    TruyenctnnAdapter truyenctnnAdapter;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_ngu_ngon);
        btnbackTNN=findViewById(R.id.imgbuttonBackTNN);
        listView=findViewById(R.id.dstruyenTNN);
        edt=findViewById(R.id.edtsearchTNN);
        btnbackTNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TruyenNguNgonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        initList();
        SearchtruyenNN();



        //Bắt click cho item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(TruyenNguNgonActivity.this,NoiDungActivity.class);
                String tent=TruyenArrayList.get(position).getTenTruyen();
                String noidungt=TruyenArrayList.get(position).getNoiDung();
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);
                startActivity(intent);

            }
        });
    }

    private void SearchtruyenNN() {
        //search

            edt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }


                @Override
                public void afterTextChanged(Editable editable) {
                    String s = edt.getText().toString();
                    truyenctnnAdapter.sortTruyenctnn(s);
                }
            });
        }


    private void initList() {
        TruyenArrayList=new ArrayList<>();
        databasedoctruyen =new databasedoctruyen(this);
        Cursor cursor=databasedoctruyen.getData3();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String tentruyen=cursor.getString(1);
            String noidung=cursor.getString(2);
            String anh=cursor.getString(3);


            TruyenArrayList.add(new TruyenActivity(id,tentruyen,noidung,anh));
            truyenctnnAdapter =new TruyenctnnAdapter(getApplicationContext(),TruyenArrayList);

            listView.setAdapter(truyenctnnAdapter);

        }
        cursor.moveToFirst();
        cursor.close();
    }
}

