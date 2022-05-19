package com.saskpolytech.cst.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {
    EditText etID;
    EditText etName;
    Button btnDone;
    private  void loadData()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        if(name!=null) etName.setText(name);
        int id = bundle.getInt("id");
        if(id!=0) etID.setText(String.valueOf(id));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        etID = findViewById(R.id.editText1);
        etName = findViewById(R.id.editText2);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(v->finish());
        loadData();
    }
}