package com.example.demo.entity;

import lombok.Data;

@Data
public class PresentEntity {
	
	/*データベースのテーブル(入力内容)と対応するEntityクラス*/	
	
	//自動生成のID番号
	private Integer id;
	
	//プレゼント（No1～6）
	private Integer present;
	
	//住所（アドレス）
	private String address;
	
	/* プレゼント番号とプレゼント名の1対1の関係 */
	private NameEntity nameEntity;
	
}
