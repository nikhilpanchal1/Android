package com.saskpolytech.cst.fileio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    private final static int READ_BUF_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = findViewById(R.id.etText);
        SharedPreferences preferences = this.getSharedPreferences(this.getPackageName(),
                Context.MODE_PRIVATE);

        findViewById(R.id.btnRead).setOnClickListener(v->{
            try {
                File path = Environment.getExternalStorageDirectory();
                File file = new File(path,"foo.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                //FileInputStream fileInputStream = openFileInput("foo.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                char[] inputBuf = new char[READ_BUF_SIZE];
                String str = "";
                int charRead;
                while((charRead=inputStreamReader.read(inputBuf))>0)
                {
                    String strRead = String.copyValueOf(inputBuf,0,charRead);
                    str+=strRead;
                }
                inputStreamReader.close();
                textBox.setText(str);
                str = preferences.getString("theValue","None");

                Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


        findViewById(R.id.btnWrite).setOnClickListener(v->{
            try {
                File path = Environment.getExternalStorageDirectory();
                File file = new File(path,"foo.txt");
                FileOutputStream outputStream = new FileOutputStream(file);
                //FileOutputStream outputStream = openFileOutput("foo.txt",MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write(textBox.getText().toString());
                outputStreamWriter.close();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("theValue",textBox.getText().toString());
                editor.commit();

                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}