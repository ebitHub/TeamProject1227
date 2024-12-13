package com.example.demo.entity;

import lombok.Data;

@Data
public class Enpresent {
	//モデルクラス

	/** ぬいぐるみ */
	private int doll;
	/** レゴ */
	private int block;
	/** ゲームソフト */
	private int game;
	/** 本 */
	private int book;
	/** 自転車 */
	private int bike;
	/** グローブ */
	private int glove;
		
	/*@Data
public class Book {
書籍ID 
	/*private int id;
夕イトル 
/*private String title;
著者 
/*private String author;
書籍と出版社の1対1の関係 
/*private Publisher publisher;
書籍とレビューの1対多の関係 
/*private List<Review> reviews;
};*/

}
