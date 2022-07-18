package com.example.androidtraining2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        // リストタップのリスナクラス登録
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    // リストがタップされた時の処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // タップされた行のデータを取得
            @SuppressWarnings("unchecked")
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            // 定食名と金額を取得
            String menuName = item.get("name");
            String menuPrice = item.get("price");
            // インテントオブジェクトを生成
            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
            // 第二画面に送るデータを格納
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            // 第二画面を起動
            startActivity(intent);
        }
    }
}