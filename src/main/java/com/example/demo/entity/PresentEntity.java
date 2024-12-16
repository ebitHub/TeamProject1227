package com.example.demo.entity;

import lombok.Data;

@Data
public class PresentEntity {
	
	/*データベースのテーブルと対応するEntityクラス*/
	
	//プレゼント（NO1～6）
	private int presentNo;
	//住所（アドレス）
	private String address;
	
}
