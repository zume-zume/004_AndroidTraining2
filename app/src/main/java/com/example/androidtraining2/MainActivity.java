package com.example.androidtraining2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // リストビューを表すフィールド
    @SuppressWarnings("all")
    private ListView _lvMenu;
    // リストビューに表示するリストデータ
    @SuppressWarnings("all")
    private List<Map<String, Object>> _menuList;
    // SimpleAdapter第4引数fromに使用する定数フィールド
    private static final String[] FROM = {"name", "price"};
    // SimpleAdapter第5引数toに使用する定数フィールド
    private static final int[] TO = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewオブジェクトを取得
        _lvMenu = findViewById(R.id.lvMenu);
        // 定食メニューリストをprivateメソッドを利用して用意し、フィールドに格納
        _menuList = createTeishokuList();
        // SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);
        // アダプタの生成
        _lvMenu.setAdapter(adapter);
        // リストタップのリスナクラスの生成
        _lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private  List<Map<String, Object>> createTeishokuList() {
        // 定食メニュー用のリストオブジェクトを用意
        List<Map<String, Object>> menuList = new ArrayList<>();
        // 「からあげ定食」のデータを格納するMapオブジェクトの用意と、menuListへのデータの登録
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        //「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        //以下データ登録の繰り返し。
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("desc", "ピリ辛回鍋肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 800);
        menu.put("desc", "本格四川風麻婆豆腐にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "青椒肉絲定食");
        menu.put("price", 900);
        menu.put("desc", "ピーマンの香り豊かな青椒肉絲にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 850);
        menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 950);
        menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }

    // リストがタップされた時の処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // タップされた行のデータを取得
            @SuppressWarnings("unchecked")
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            // 定食名と金額を取得
            String menuName = (String) item.get("name");
            Integer menuPrice = (Integer) item.get("price");
            // インテントオブジェクトを生成
            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
            // 第二画面に送るデータを格納
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice + "円");
            // 第二画面を起動
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();
        // オプションメニュー用.xmlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }
}