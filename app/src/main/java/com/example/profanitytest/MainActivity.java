package com.example.profanitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class MainActivity extends AppCompatActivity {

    EditText id,sen;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sen = (EditText)  findViewById(R.id.sen);
        btn = (Button)  findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);


        if(! Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        final  PyObject pyobj = py.getModule("main");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PyObject obj= pyobj.callAttr("main",sen.getText().toString());
                tv.setText(obj.toString());
            }
        });
    }
}