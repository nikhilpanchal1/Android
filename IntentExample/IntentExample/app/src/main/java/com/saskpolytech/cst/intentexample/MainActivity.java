package com.saskpolytech.cst.intentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnActivity1;
    Button btnActivity2;
    Button btnActivity3;
    Button btnActivity4;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                String rs = data.getStringExtra("result");
                Toast.makeText(this, rs, Toast.LENGTH_LONG).show();
            }
            else if(resultCode == Activity.RESULT_CANCELED)
            {
                Toast.makeText(this,"Cancelled",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),
                        Activity1.class);
                startActivity(intent);
            }
        });

        btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),
                        Activity2.class);
                intent.putExtra("name","alex");
                intent.putExtra("id",12345);
                startActivity(intent);
            }
        });

        btnActivity3 = findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),
                        Activity3.class);
                startActivityForResult(intent,1);
            }
        });
        btnActivity4 = findViewById(R.id.btnActivity4);
        btnActivity4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

    }
}