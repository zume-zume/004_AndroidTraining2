package com.example.androidtraining2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        // ListViewをリスナに設定
        List<String> menuList = new ArrayList<>();
        // リストデータの登録
        menuList.add("からあげ定食");
        menuList.add("ハンバーグ定食");
        menuList.add("焼肉定食");
        menuList.add("生姜焼き定食");
        menuList.add("野菜炒め定食");
        menuList.add("とんかつ定食");
        menuList.add("チキンカツ定食");
        menuList.add("回鍋肉定食");
        menuList.add("焼き魚定食");
        menuList.add("青椒肉絲定食");
        // アダプタオブジェクトの作成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, menuList);
        // リストビューにアダプタオブジェクトを設定
        lvMenu.setAdapter(adapter);
        // リストビューにリスナーを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    // リストがタップされた時の処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 注文確認ダイアログフラグメントオブジェクトを生成
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            // ダイアログ表示
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}