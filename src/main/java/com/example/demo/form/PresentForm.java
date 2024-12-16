package com.example.demo.form;

import lombok.Data;

@Data
public class PresentForm {

	/*入力データを一時的に保持するForm*/
	
	//プレゼント（NO1～6）
	private int presentNo;
	//住所（アドレス）
	private String address;
}
