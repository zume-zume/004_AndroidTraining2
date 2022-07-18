# 004_AndroidTraining2
Android開発を行うにあたっての基礎知識をモスモスするためのリポジトリ

# それぞれのファイルの役目
ファイルの役目を綴る

## res/values/strings.xml
→アプリ内で画面表示する文字列は、原則このxmlファイルに定義してあげること。

## res/layout/activity_main.xml
→初期画面用のレイアウトファイル  
・ConstraintLayout：画面部品を相対的に配置  
・LinearLayout：入門者にも扱いやすい。画面部品を縦横に並べて配置  
　・android:orientation属性を  
　　→horizontalで横方向  
　　→verticalで縦方向  
・他にもTableLayout、FrameLayout、RelativeLayoutがあるけど、割愛
  
# 用語のメモ
用語のメモ↓

## apk  
.apkの拡張子を持つAndroidにインストールできるアプリケーションファイル  
ZIPファイルのようなもの  

参考：https://jp.malavida.com/faq/malavida-app-store/android/what-is-an-apk-and-what-is-it-for.html#gref  

## コンテキスト（context）  
アプリケーション固有のリソースとクラスへのアクセス、およびアクティビティの起動、  
インテントのブロードキャストと受信などのアプリケーションレベルの操作のアップコールを可能にする。  
コンテキストはActivityの親クラスであり、様々な引数をして使用される。  
コンテキストの指定は、通常Activityインスタンスを指定する。  
getApplicationContext()の戻り値を利用する方法もあるが、これだとコンテキストの指定が不明瞭になりがちなので、  
「アクティビティクラス名.this」と書くことで、どのアクティビティなのかわかりやすい。  
  
## ビューグループ
各画面部品の配置を決める。レイアウト部品とも呼ばれる。
* LinearLayout：画面部品を縦横で並べて配置
* TableLayout：表形式で配置
* FrameLayout：重ねて配置
* RelativeLayout：部品を相対的に配置
* ConstraintLayout：部品を相対的に配置（RelativeLayoutよりも使いやすい）

## ビュー（View）  
画面部品そのもので、ウィジェットとも呼ぶ。  
色んなビューがあるので、覚えておくこと  
* TextView：文字列の表示
* EditText：テキストボックス（数字のみ等の入力制限もできる）
* Button：ボタン
* radioButton：ラジオボタン
* CheckBox：チェックボックス
* Spinner：ドロップダウンリスト
* ListView：リスト表示
* SeekBar：スライダー
* RatingBar：☆でレート値を表示
* Switch：OnOffが表現できるスイッチ  
などなど  
  
## トースト(Toast)
画面下部に文字列を表示させて、そのうち消えるポップアップみたいな機能  
`Toast.makeText(引数1, 引数2, 引数3).show()`
引数1:Context context→トーストを表示させるアクティビティオブジェクト。通常は「アクティビティクラス名.this」か、getApplicationContext()の戻り値を使う  
引数2:CharSequence text→表示する文字列  
引数3:int duration→トーストの長さをToastクラスの定数で指定。Toast.LENGTH_LONGと、~_SHORTの二種類しかない

## インテント(Intent)
明示的インテントと暗黙的インテントがある。  
明示的インテントだと、例えば、
`intent.putExtra("AAA", xxx);`
`startActivity(intent);`
こんな感じでインテントに情報を詰めて、アクティビティを指定して起動して、
`Intent intent = getIntent();`
`intent.getStringExtra("AAA");`
起動されるアクティビティ側で情報を受け取る。  
  
## アダプタ(Adapter)
リストビューに表示するリストデータを管理して、リストビューの各行にそのリストデータを当てはめていく働きをするオブジェクト  
* ArrayAdapter:元データとしてLIST（配列）を利用するアダプタクラス
* SimpleAdapter：元データとしてList<Map<String,?>>を利用するアダプタクラス。XMLやJSONデータの格納ができる。
* SimpleCursorAdapter：元データとしてCursorオブジェクト（※）を利用するアダプタクラス。
　※Cursorオブジェクトは、Android端末内のDBを利用する際、SELECT文の結果が格納されたもの。
  
### SimpleAdapter(シンプルアダプター)
`SimpleAdapter(Context context, List<Map<>String, ?>, int resource, string[] from, int[] to)  `
第一引数：コンテキスト。「Activity.this」  
第二引数：リストデータ  
第三引数：リストビューのレイアウト  
第四引数：各画面部品に割り当てるデータを表すMapのキー名  
第五引数：fromに記載のMapのキー名に対応してデータを割り当てられる画面部品のR値の配列  
  
## MinimumSDK  
アプリが動作する最小のAPIレベル。たとえば「APIレベル16」を指定すると、  
「APIレベル15」以前のAndroidOSでは動作が保証されない。  
より広い範囲の端末を対象としたい場合は、APIのレベルを下げればいいが、そうすると使えないAPIが出てくる。  
逆にレベルを上げることで動作対象の範囲を狭めることになるけど、最新の機能が使える。  

## drawableとmipmap
画像やアイコンを格納するフォルダ。
drawable：アプリで静止画像を表示する必要がある場合、Drawableクラスとそのサブクラスを使用して、図形と画像を描画できる。  
mipmap：3Dで使われていて、遠くの物体には荒いテクスチャ。近くの物体には細かいテクスチャを適用して、クオリティとメモリを両立させる技術。  
  
## Rクラス  
リソースを管理してくれるクラス。　　
具体的には、resフォルダ内のファイルに記述された「@+id」の値などのリソースをjava側から効率よく  
利用できるように使われるint型の定数クラスのこと。クラスの中の定数はR値と呼ばれる。  

ちなみに、AndroidSDKでよういされたリソースもR値が割り当てられており、そのクラスがAndroid.R。  
アプリ内の独自のRクラスとクラス名が同じなので、Android.Rクラスをインポートしてしまうと、  
独自のRクラスが呼び出されなくなってしまうので、インポートしないようにすること。
`Android.R.layout.simple_list_item_1`
のように記述すること。  

## ログ・ログレベル
| ログレベル | 内容 | 対応メソッド |
----|----|----
| Assert | 絶対に発生してはいけない問題 | wft() |
| Error | エラーを引き起こした問題 | e() |
| Warning | エラーとは言えない潜在的な問題 | w() |
| Info | 通常の使用で発生 | i() |
| Debug | 詳細なメッセージ（製品版アプリでも出る） | d() |
| Verbose | 詳細なメッセージ（製品版アプリでは出ない） | v() |
  
ログの確認は、Logcatで行う。検索窓にキーワードを入力することで、ログを絞り込むことができる。  
Logcat右上でログフィルタリングを設定できる。
| フィルタ名 | 内容 |
----|----
| Show only selected application | 現在実行中のアプリのログのみ | 
| Firebase | Firebaseに関するログを出力 | 
| No filters | そのデバイスで実行されている全てのアプリのログ | 
| Edit Filter Configuration | カスタムフィルタを作成するためのダイアログの表示 | 
  

# 困りごと

## エミュレータがフリーズした・真っ暗になったとき
Device(AVD)Manager > 起動するエミュレータの▼ > WipeData  
で、データを初期化することができる。ディスク上のサイズが大幅に削減されて、初期化されたことがわかる。




