package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Enpresent;

@Mapper
public interface PresentMapper {

    // プレゼント情報をデータベースに挿入
    @Insert("INSERT INTO enpresent (doll, block, game, book, bike,glove) VALUES (#{doll}, #{block}, #{game}, #{book}, #{bike}, #{glove})")
    void insertPresent(Enpresent present);

    // 全てのリクエストを取得
    @Select("SELECT * FROM enpresent")
    List<Enpresent> selectAll(); // 全てのプレゼント情報を取得
}
