package com.example.androidtraining2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        // SimpleAdapterで使用するListオブジェクトを用意する。
        List<Map<String, String>> menuList = new ArrayList<>();
        // 「からあげ定食」のデータを格納するMapオブジェクトの用意と、menuListへのデータの登録
        Map<String, String> menu = new HashMap<>();
        menu.put("name", "からあげ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", "1000円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "しょうがやき定食");
        menu.put("price", "800円");
        menuList.add(menu);


        // SimpleAdapter第4引数from用のデータの用意
        String[] from = {"name", "price"};
        // SimpleAdapter第5引数to用のデータの用意
        int[] to = {android.R.id.text1, android.R.id.text2};
        // SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, android.R.layout.simple_list_item_2, from, to);
        // アダプタの登録
        lvMenu.setAdapter(adapter);
    }
}