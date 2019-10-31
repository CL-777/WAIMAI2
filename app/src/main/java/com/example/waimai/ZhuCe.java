package com.example.waimai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ZhuCe extends AppCompatActivity {

    public EditText yonghuming;
    public EditText mima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
    }

    public void zhuce(View v){
        Intent intent = getIntent();

        yonghuming = findViewById(R.id.yonghuming);
        Bundle bundle = new Bundle();
        bundle.putString("yonghuming",yonghuming.getText().toString());
        bundle.putInt("mima",Integer.parseInt(mima.getText().toString()));
    }
}
