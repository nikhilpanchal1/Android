package com.saskpolytech.cst.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity
        implements View.OnClickListener{
    Button btnOK;
    Button btnCancel;
    EditText etPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        etPhase = findViewById(R.id.editText3);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnOK:
                String sVal = etPhase.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("result",sVal);
                setResult(RESULT_OK,intent);
                finish();
            break;
            case R.id.btnCancel:
                Intent intent1 = new Intent();
                setResult(RESULT_CANCELED,intent1);
                finish();
                break;
        }
    }
}