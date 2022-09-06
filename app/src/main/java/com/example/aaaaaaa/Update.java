package com.example.aaaaaaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {


    EditText order2, sub2, name2, price2;
    Button btn_update, btn_delete;

    String id, order, sub, name, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        order2 = findViewById(R.id.edit_order2);
        sub2 = findViewById(R.id.edit_sub2);
        name2 = findViewById(R.id.edit_name2);
        price2 = findViewById(R.id.edit_price2);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        getnSetData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(Update.this);
                order = order2.getText().toString().trim();
                sub = sub2.getText().toString().trim();
                name = name2.getText().toString().trim();
                price = price2.getText().toString().trim();

                myDB.updateData(id, order, sub, name, price);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm();
            }
        });
    }

    void getnSetData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("ord") && getIntent().hasExtra("sub")
                && getIntent().hasExtra("nam") && getIntent().hasExtra("num")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            order = getIntent().getStringExtra("ord");
            sub = getIntent().getStringExtra("sub");
            name = getIntent().getStringExtra("nam");
            price = getIntent().getStringExtra("num");

            //Setting Intent Data
            order2.setText(order);
            sub2.setText(sub);
            name2.setText(name);
            price2.setText(price);
            Log.d("22", order+" "+sub+" "+name+" "+name);

        }else{
            Toast.makeText(this, "조회할 데이터가 없습니다", Toast.LENGTH_SHORT).show();
        }
    }

    void confirm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("(주의)삭제");
        builder.setMessage("삭제하시겠습니까?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int oldVersion) {
                DBHelper myDB = new DBHelper(Update.this);
                myDB.deleteOne(id);
                finish();
            }

        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}











