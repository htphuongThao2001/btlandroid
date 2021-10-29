package com.example.truyenchu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.truyenchu.R;
import com.example.truyenchu.adapter.MenuAdapter;
import com.example.truyenchu.adapter.TruyenAdapter;
import com.example.truyenchu.database.databasedoctruyen;
import com.example.truyenchu.object.ItemMenu;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    GridView DStruyen;
    NavigationView navigationView;
    ListView listViewMHC;
    DrawerLayout drawerLayout;
    ArrayList<ItemMenu> arrayList;
    MenuAdapter adapter;

    ArrayList<TruyenActivity> TruyenArraylist;
    TruyenAdapter truyenAdapter;

    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        databasedoctruyen = new databasedoctruyen(this);
        Anhxa();
        ActionViewFlipper();
        ActionMenu();
        ActionNavigation();
        //bắt sự kiện click item
        DStruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id) {
                Intent intent = new Intent(MainActivity.this, NoiDungActivity.class);

                String tent = TruyenArraylist.get(positon).getTenTruyen();
                String noidungt = TruyenArraylist.get(positon).getNoiDung();
                intent.putExtra("tentruyen", tent);
                intent.putExtra("noidung", noidungt);
                startActivity(intent);
            }
        });
            }

    private void ActionNavigation() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        listViewMHC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position ==0) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (position ==1) {
                    Intent intent = new Intent(MainActivity.this, TruyenCoTichActivity.class);
                    startActivity(intent);
                }
                else if (position ==2) {
                    Intent intent = new Intent(MainActivity.this, TruyenNguNgonActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void ActionMenu() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemMenu("Trang chủ",R.drawable.trangchu));
        arrayList.add(new ItemMenu("Truyện cổ tích",R.drawable.ictruyencotich));
        arrayList.add(new ItemMenu("Truyện ngụ ngôn",R.drawable.ictruyenngungon));
        adapter = new MenuAdapter(this, R.layout.dong_item, arrayList);
        listViewMHC.setAdapter(adapter);
    }



    private void ActionViewFlipper() {
        ArrayList<Integer> mangquangcao = new ArrayList<>();
        mangquangcao.add(R.drawable.chucbengungon);
        mangquangcao.add(R.drawable.doraemon);
        mangquangcao.add(R.drawable.cotich);
        mangquangcao.add(R.drawable.totoro);
        mangquangcao.add(R.drawable.webarebear);

        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            //imageview căn vừa với viewflipper, k bị cắt
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //add viewflipper
            viewFlipper.addView(imageView);
        }
        //Bắt sự kiện cho viewflipper tự chạy
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }



    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        DStruyen = (GridView)  findViewById(R.id.dstruyen);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewMHC = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        //thêm
        TruyenArraylist =new ArrayList<>();
        Cursor cursor1=databasedoctruyen.getData1();
        while (cursor1.moveToNext()){
            int id=cursor1.getInt(0);
            String tentruyen= cursor1.getString(1);
            String noidung= cursor1.getString(2);
            String anh=cursor1.getString(3);

            TruyenArraylist.add(new TruyenActivity(id,tentruyen,noidung,anh));
            truyenAdapter=new TruyenAdapter(getApplicationContext(),TruyenArraylist);
            DStruyen.setAdapter(truyenAdapter);

        }
        cursor1.moveToFirst();
        cursor1.close();

    }

}
