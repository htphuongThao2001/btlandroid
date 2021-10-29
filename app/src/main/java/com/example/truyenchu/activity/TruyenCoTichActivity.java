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
import com.example.truyenchu.adapter.TruyenAdapter;
import com.example.truyenchu.adapter.TruyenctnnAdapter;
import com.example.truyenchu.database.databasedoctruyen;

import java.util.ArrayList;

public class TruyenCoTichActivity extends AppCompatActivity {
    ImageButton btnback;
    ListView listView;
    EditText edt;
    ArrayList<TruyenActivity> TruyenArrayList;


    ArrayList<TruyenActivity> arrayList;
    TruyenctnnAdapter truyenctnnAdapter;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_co_tich);
        btnback=findViewById(R.id.imgbuttonBackTCT);
        listView=findViewById(R.id.dstruyenTCT);
        edt=findViewById(R.id.edtsearchTCT);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(TruyenCoTichActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        initList();
        Searchtruyen();


        //Bắt click cho item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(TruyenCoTichActivity.this,NoiDungActivity.class);
                String tent=TruyenArrayList.get(position).getTenTruyen();
                String noidungt=TruyenArrayList.get(position).getNoiDung();
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);
                startActivity(intent);

            }
        });
    }
    //search
    private void Searchtruyen() {
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
        arrayList=new ArrayList<>();
        databasedoctruyen =new databasedoctruyen(this);
        Cursor cursor=databasedoctruyen.getData2();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String tentruyen=cursor.getString(1);
            String noidung=cursor.getString(2);
            String anh=cursor.getString(3);
            //thêm id loại truyện
            int idloaitruyen=cursor.getInt(4);
            TruyenArrayList.add(new TruyenActivity(id,tentruyen,noidung,anh));

            arrayList.add(new TruyenActivity(id,tentruyen,noidung,anh));
            truyenctnnAdapter =new TruyenctnnAdapter(getApplicationContext(),TruyenArrayList);

            listView.setAdapter(truyenctnnAdapter);

        }
        cursor.moveToFirst();
        cursor.close();
    }
}