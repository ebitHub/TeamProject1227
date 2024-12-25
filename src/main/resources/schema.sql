-- テーブルが存在したら削除する
DROP TABLE IF EXISTS present_list;
DROP TABLE IF EXISTS present_name;
DROP TABLE IF EXISTS authentications;

-- プレゼント名を格納するテーブルの作成
CREATE TABLE present_name (
    -- プレゼントID: 主キー（自動生成）
    present_id SERIAL PRIMARY KEY,
    -- プレゼント名: NULL不許可
    name VARCHAR(20) NOT NULL
);

-- 入力内容を格納するテーブルの作成
CREATE TABLE present_list (
    -- ID: 主キー（自動生成）
    id SERIAL PRIMARY KEY,
    -- プレゼント番号: NULL不許可、外部キー制約
    present INTEGER NOT NULL,
    -- 住所: NULL不許可
    address VARCHAR(250) NOT NULL,
    -- 外部キー設定
     present_id INTEGER REFERENCES present_name(present_id) ON DELETE CASCADE
    );
   
-- 認証情報を格納するテーブル
CREATE TABLE authentications (
 -- ユーザー名：主キー
 username VARCHAR(50) PRIMARY KEY,
 -- パスワード
 password VARCHAR(255) NOT NULL
);