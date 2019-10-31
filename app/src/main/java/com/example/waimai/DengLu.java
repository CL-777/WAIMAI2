package com.example.waimai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DengLu extends AppCompatActivity {

    public EditText yonghuming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
    }

    public void denglu (View v){
        yonghuming = findViewById(R.id.dengluyonghuming);

        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("yonghuming",yonghuming.getText().toString());
        intent.putExtras(bundle);
        setResult(1,intent);

        finish();
    }
}
