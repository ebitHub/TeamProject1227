--テーブルが存在したら削除する
DROP TABLE IF EXISTS present_list

--テーブルの作成
CREATE TABLE present_list(
	--ID:主キー（自動生成）
	id serial PRIMARY KEY,
	--プレゼント番号:NULL不許可
	present VARCHAR(1) NOT NULL,
	--住所:NULL不許可
	adress VARCHAR(250) NOT NULL