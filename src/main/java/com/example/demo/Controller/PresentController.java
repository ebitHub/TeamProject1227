package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.PresentForm;

import jakarta.validation.Valid;

@Controller
public class PresentController {

    // 入力画面（inputビュー）を表示
    @GetMapping("/input")
    public String showForm(Model model) {
        model.addAttribute("form", new PresentForm());
        return "input";  // input.htmlビュー
    }

    // 確認画面（confirmビュー）に遷移
    @PostMapping("/confirm")
    public String confirmForm(@ModelAttribute @Valid PresentForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 入力チェックNGの場合、入力画面に戻る
            return "input";
        }
        // 確認用にフォームデータをモデルに追加
        model.addAttribute("form", form);
        return "confirm";  // confirm.htmlビュー
    }
    // 成功画面（successビュー）に遷移
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute PresentForm form) {
        // フォームの送信後の処理（例: 保存など）
        System.out.println("プレゼント番号: " + form.getPresentNo());  // 修正済み
        System.out.println("住所: " + form.getAddress());
        return "success";  // success.htmlビュー
    }

    // リスト画面（listビュー）を表示
    @GetMapping("/list")
    public String showList() {
        // 何らかのリストを表示するための処理
        return "list";  // list.htmlビュー
    }
}
