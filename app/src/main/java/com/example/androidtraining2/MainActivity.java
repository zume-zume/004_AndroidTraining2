package com.example.androidtraining2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

        registerForContextMenu(_lvMenu);
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
            order(item);
        }
    }

    private List<Map<String, Object>> createCurryList() {
        // カレーメニューリスト用のListオブジェクトを用意
        List<Map<String, Object>> menuList = new ArrayList<>();
        // 「ビーフカレー」のリストを格納するMapオブジェクトを用意し、ListViewを登録
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
        menuList.add(menu);
        // 「ビーフカレー」のリストを格納するMapオブジェクトを用意し、ListViewを登録
        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
        menuList.add(menu);
        return menuList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();
        // オプションメニュー用.xmlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 戻り値用の変数を初期値trueで用意
        boolean returnVal = true;
        // 選択されたメニューのIDを取得
        int itemId = item.getItemId();

        if (itemId == R.id.menuListOptionTeishoku) {
            // 定食メニューが選択された場合、定食メニューリストデータの生成
            _menuList = createTeishokuList();
        } else if (itemId == R.id.menuListOptionCurry) {
            // カレーメニューが選択された場合、カレーメニューリストデータの生成
            _menuList = createCurryList();
        } else {
            // 親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする。
            returnVal = super.onOptionsItemSelected(item);
        }
        // SimpleAdapterを選択されたメニューデータで生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);
        // アダプタの登録
        _lvMenu.setAdapter(adapter);
        return returnVal;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        // 親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, view, menuInfo);
        // メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();
        // コンテキストメニュー用の.xmlファイルのインポート
        inflater.inflate(R.menu.menu_context_menu_list, menu);
        // コンテキストメニューへのヘッダタイトルの指定
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }

    private void order(Map<String, Object> menu) {
        // 定食名と金額を取得。
        String menuName = (String) menu.get("name");
        Integer menuPrice = (Integer) menu.get("price");
        // インテントオブジェクトを作成
        Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
        // 第二画面に送るデータ
        intent.putExtra("menuName", menuName);
        // MenuThanksActivityでのデータ受け取りと合わせるために、「円」を追加
        intent.putExtra("menuPrice", menuPrice + "円");
        // 第二画面を起動
        startActivity(intent);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // 戻り値用の変数を初期値trueで設定
        boolean returnVal = true;
        // 長押しされたビューに関する情報が格納されたオブジェクトを取得
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // 長押しされたリストのポジションを取得
        int listPosition = info.position;
        // ポジションから長押しされたメニュー情報のMapオブジェクトを取得
        Map<String, Object> menu = _menuList.get(listPosition);

        // 選択されたメニューのIDを取得
        int itemId = item.getItemId();
        if (itemId == R.id.menuListContextDesc) {
            // 「説明を表示」が押下された時
            String desc = (String) menu.get("desc");
            // トーストを表示
            Toast.makeText(MainActivity.this, desc, Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.menuListContextOrder) {
            // 注文処理
            order(menu);
        } else {
            // 親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする。
            returnVal = super.onContextItemSelected(item);
        }
        return returnVal;
    }

}