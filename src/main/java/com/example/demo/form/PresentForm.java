package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PresentForm {

	/*入力データを一時的に保持するForm*/	
	//プレゼント（NO1～6）
	@NotNull(message = "数値が未入力です。")
//	@Range(min = 1, max = 6, message = "{min}～{max}の数値を入力して下さい。")
	private int presentNo;
	//住所（アドレス）
	@NotNull(message = "住所が未入力です。")
	@Length(min = 1, max = 250)
	private String address;
}
