README


目次

【概要】
【実行方法】
　①DB作成
　②eclipseへのプロジェクトのインポートと起動
　③実行

-------------------------------------------------------


【概要】
このアプリは、サンタさんがプレゼントと配布先を管理するためのアプリです。
子供たちは入力画面から住所と希望するプレゼントを登録し、サンタさんは管理画面から登録された住所・プレゼントを確認できます。


【実行方法】
①DB作成
1. pgAdminを起動し、「PostgreSQL 16」に入る

2. ユーザー作成
2_1. ツリービューの「Login/Group Role」を右クリックし、「Create」から「Login/Group Role」をクリック
2_2. タブ「General」のName項目に「springuser」を設定
2_3. タブ「Definition」のPassword項目に「p@ss」を設定
2_4. タブ「Privileges」のCan login項目とSuperuser項目をオン
2_5. Saveボタンをクリックしてユーザー作成を完了

3. DBの作成 
3_1. ツリービューの「Databases」を右クリックし、「Create」から「Database」をクリック
3_2. タブ「General」のDatabase項目に「springdb」、Owner項目に「springuser」を設定
3_3. SaveボタンをクリックしてDB作成を完了



②eclipseへのプロジェクトのインポートと起動
1. 「TeamProject1227」プロジェクトをeclipseにインポートする
1_1. 「ファイル」から「インポート」を選択
1_2. 「既存プロジェクトをワークスペースへ」を選択
1_3. 「ルート・ディレクトリーの選択」で「TeamProject1227」フォルダを参照し、プロジェクトをインポート

2. 「TeamProject1227」プロジェクトを起動



③実行
1. ブラウザで「http://localhost:8080/input」にアクセスすると、プレゼントリクエスト画面へ

2_1. ブラウザで「http://localhost:8080/login」にアクセスすると、ログイン画面へ
2_2. usernameに「santa」、passwordに「Christmas_2024_test」を入力してプレゼント管理画面へログイン
