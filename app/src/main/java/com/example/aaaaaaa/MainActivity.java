package com.example.aaaaaaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    FloatingActionButton addBtn;

    DBHelper myDB;
    ArrayList<String> id, order, sub, name, price;
    CustomAdapter customAdapter;

    TextView ttt1;
    TextView ttt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        addBtn = findViewById(R.id.btn_dia);

        //데이터 추가
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                startActivity(intent);
            }
        });

        myDB = new DBHelper(MainActivity.this);
        id = new ArrayList<>();
        order = new ArrayList<>();
        sub = new ArrayList<>();
        name = new ArrayList<>();
        price = new ArrayList<>();

        //데이터 가져와서 저장 n 리싸이클러뷰에 반영
        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, this, id, order, sub, name, price);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //데이터들 계산한 값들 불러와서 TextView에 띄어주기
        int total1 = myDB.CalTot1();
        ttt1 = (TextView)findViewById(R.id.total1);
        ttt1.setText(total1+"");

        int total2 = myDB.CalTot2();
        ttt2 = (TextView)findViewById(R.id.total2);
        ttt2.setText(total2+"");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storeDataInArrays(){ //데이터 등록
        Cursor cursor = myDB.readData();
        if(cursor.getCount() == 0){
        }else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                order.add(cursor.getString(1));
                sub.add(cursor.getString(2));
                name.add(cursor.getString(3));
                price.add(cursor.getString(4));
            }
        }
    }

    //항목 모두 지우기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("(주의)전부 삭제");
        builder.setMessage("정말로 다 지우실 거에요?");
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper myDB = new DBHelper(MainActivity.this);
                myDB.deleteAll();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }
























}