package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PresentForm {

	/*入力データを一時的に保持するForm*/	
	//プレゼント（NO1～6）
	@NotNull(message = "数値が未入力です。")
	private Integer present;
	
	//住所（アドレス）
	@NotBlank(message = "住所は必須入力です。")
	@Length(min = 1, max = 250, message = "住所は1文字以上、250文字以内で入力してください。")
	private String address;
}
