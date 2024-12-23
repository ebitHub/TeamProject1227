package com.example.demo.entity;

import lombok.Data;

@Data
public class NameEntity {

	/*データベースのテーブル(プレゼント名)と対応するEntityクラス*/

	//プレゼントのID
	private Integer presentId;

	//プレゼント名
	private String name;
	
	// プレゼントの登録数
    private Integer count;  // 集計結果を格納するフィールド
}
