package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.NameEntity;
import com.example.demo.entity.PresentEntity;

@Mapper
public interface PresentMapper {
	/*全件取得*/
    List<PresentEntity> getAllPresentEntities();
    
	/*登録*/
    void insertPresentEntity(PresentEntity presentEntity);
    
    /*プレゼント名の取得*/
    NameEntity getPresentName(int id);
    
    /*プレゼントごとの個数集計*/
    @Select("""
            SELECT 
                pn.present_id AS presentId,
                pn.name AS name,
                COUNT(pl.present) AS count
            FROM present_name pn
            LEFT JOIN present_list pl ON pn.present_id = pl.present
            GROUP BY pn.present_id, pn.name
            ORDER BY pn.present_id
        """)
        List<NameEntity> getPresentCounts();
    
    
//    // プレゼント情報をデータベースに挿入
//    @Insert("INSERT INTO enpresent (doll, block, game, book, bike,glove) VALUES (#{doll}, #{block}, #{game}, #{book}, #{bike}, #{glove})")
//    void insertPresent(Enpresent present);
//
//    // 全てのリクエストを取得
//    @Select("SELECT * FROM enpresent")
//    List<Enpresent> selectAll(); // 全てのプレゼント情報を取得
      
}
