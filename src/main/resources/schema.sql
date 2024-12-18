-- テーブルが存在したら削除する
DROP TABLE IF EXISTS present_list;

-- テーブルの作成
CREATE TABLE present_list (
    -- ID: 主キー（自動生成）
    id SERIAL PRIMARY KEY,
    -- プレゼント番号: NULL不許可
    present INTEGER ,
    -- 住所: NULL不許可
    address VARCHAR(250)
);