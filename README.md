# 004_AndroidTraining2
Android開発を行うにあたっての基礎知識をモスモスするためのリポジトリ

# それぞれのファイルの役目
ファイルの役目を綴ろう

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
  
# 用語のメモメモ  
用語のメモ↓

## apk  
.apkの拡張子を持つAndroidにインストールできるアプリケーションファイル  
ZIPファイルのようなもの  

参考：https://jp.malavida.com/faq/malavida-app-store/android/what-is-an-apk-and-what-is-it-for.html#gref  
  
## ビュー（View）  
画面部品そのもので、ウィジェットとも呼ぶよ。  
色んなビューがあるので、覚えておくこと  
* TextView：文字列の表示
* EditText：テキストボックス（数字のみ等の入力制限もできる）
* Button：ボタン
* radioButton：ラジオボタン
* CheckBox：チャックボックス
* Spinner：ドロップダウンリスト
* ListView：リスト表示
* SeekBar：スライダー
* RatingBar：☆でレート値を表示
* Switch：OnOffが表現できるスイッチ  
などなど  

## 