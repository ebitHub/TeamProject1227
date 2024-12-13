package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Enpresent; // エンティティクラス
import com.example.demo.mapper.PresentMapper; // マッパークラス

@Service
public class PresentService {

    @Autowired
    private PresentMapper presentMapper;

    // プレゼントのリクエストを保存
    public void savePresent(Enpresent request) {
        presentMapper.insertPresent(request); // PresentMapperを使ってデータベースに保存
    }

    // 全てのリクエストを取得
    public List<Enpresent> getAllRequests() {
        return presentMapper.selectAll(); // 全てのリクエストを取得
    }
}
