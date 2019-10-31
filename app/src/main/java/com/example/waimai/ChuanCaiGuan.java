package com.example.waimai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ChuanCaiGuan extends ListActivity implements Runnable{

    String data[] = {"one","two","three"};
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chuan_cai_guan);

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
        Log.i("bb","bbbb");



        Thread t = new Thread(this);
        t.start();
        handler = new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                if(msg.what==5){
                    String str = (String)msg.obj;
                    Log.i("aaa","aaaaaaaaaa"+str);
                }

            }
        };
    }

    @Override
    public void run() {
        for(int i=1;i<6;i++){
            Log.i("bb","bb:"+ i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Message msg = handler.obtainMessage(5);
        msg.obj = "hello";
        handler.sendMessage(msg);

        /*URL url = null;
        try {
            url = new URL("https://www.so.com/s?q=%E5%B7%9D%E8%8F%9C%E9%A6%86&src=srp&fr=360se7_addr&psid=4391917dad0fe52cf273de7e57a9bded");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            Log.i("aaa","aaaaaaaaaabbccc");
            InputStream inputStream =http.getInputStream();
            Log.i("aaa","aaaaaaaaaabb");

            Log.i("aaa","aaaaaaaaaabbbbbbb");
            String html = inputStream2String(inputStream);
            Log.i("aa","aaaaaa"+ html);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.so.com/s?q=%E7%BE%8E%E5%9B%A2%E5%95%86%E5%AE%B6%E6%95%B0%E6%8D%AE&src=srp&fr=hao_360so_b&psid=6ea5f2a7e3b671242b5a9f646de14b5e").get();
            //Elements headlines = doc.select("#mp-itn b a");
            Log.i("aaabbbccc","aa" + doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String inputStream2String (InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "UTF-8");
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }

}
