package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.PresentEntity;
@Mapper
public interface PresentMapper {
	/*全件取得*/
    List<PresentEntity> getAllPresentEntities();
	/*登録*/
    void insertPresntEntity(PresentEntity presentEntity);
    
    
    
//    // プレゼント情報をデータベースに挿入
//    @Insert("INSERT INTO enpresent (doll, block, game, book, bike,glove) VALUES (#{doll}, #{block}, #{game}, #{book}, #{bike}, #{glove})")
//    void insertPresent(Enpresent present);
//
//    // 全てのリクエストを取得
//    @Select("SELECT * FROM enpresent")
//    List<Enpresent> selectAll(); // 全てのプレゼント情報を取得
      
}
