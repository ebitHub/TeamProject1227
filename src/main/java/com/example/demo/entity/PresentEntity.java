package com.example.demo.entity;

import lombok.Data;

@Data
public class PresentEntity {
	
	/*データベースのテーブルと対応するEntityクラス*/	
	
	//自動生成のID番号
	private Integer id;
	
	//プレゼント（No1～6）
	private Integer present;
	
	//住所（アドレス）
	private String address;
	
}
