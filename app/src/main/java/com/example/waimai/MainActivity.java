package com.example.waimai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView xingming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void b1(View v){
        Intent ccxl = new Intent(this,ChuanCaiGuan.class);
        startActivity(ccxl);
    }

    public void b2(View v){
        Intent ccxl = new Intent(this,ChuanCaiGuan.class);
        startActivity(ccxl);
    }
    public void b3(View v){
        Intent ccxl = new Intent(this,ChuanCaiGuan.class);
        startActivity(ccxl);
    }
    public void b4(View v){
        Intent ccxl = new Intent(this,ChuanCaiGuan.class);
        startActivity(ccxl);
    }

    public void shezhi(View v){
        Intent ccxl = new Intent(this,SheZhi.class);
        startActivity(ccxl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.caidan,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.denglu:
                Intent denglu = new Intent(this,DengLu.class);
                startActivityForResult(denglu,1);
                break;
            case R.id.zhuce:
                Intent zhuce = new Intent(this,ZhuCe.class);
                startActivity(zhuce);
                break;
            case R.id.shezhi:
                Intent shezhi = new Intent(this,SheZhi.class);
                startActivity(shezhi);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            Bundle bundle = data.getExtras();
            xingming = findViewById(R.id.xingming);
            xingming.setText(bundle.getString("yonghuming","空"));

        }
    }
}
