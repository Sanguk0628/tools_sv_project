package com.example.aaaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {

    EditText order1, sub1, name1, price1;
    Button btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        order1 = findViewById(R.id.edit_order1);
        sub1 = findViewById(R.id.edit_sub1);
        name1 = findViewById(R.id.edit_name1);
        price1 = findViewById(R.id.edit_price1);
        btn_enter = findViewById(R.id.btn_enter);

        //입력하면 데이터 get
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(Add.this);
                myDB.addData(Integer.valueOf(order1.getText().toString().trim()),
                        Integer.valueOf(sub1.getText().toString().trim()),
                        name1.getText().toString().trim(),
                        Integer.valueOf(price1.getText().toString().trim()));
            }
        });


    }
}
