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
		try {
			model.addAttribute("form", new PresentForm()); // PresentFormオブジェクトをform属性として追加
			return "input"; // input.htmlビューが返される
		} catch (Exception e) {
			// エラーが発生した場合、エラーログを出力
			e.printStackTrace(); // スタックトレースをコンソールに表示
			model.addAttribute("error", "入力画面の表示に失敗しました"); // エラーメッセージをモデルに追加
			return "error"; // error.htmlビューに遷移
		}
	}

	// 確認画面（confirmビュー）に遷移
	@PostMapping("/confirm")
	public String confirmForm(@ModelAttribute @Valid PresentForm form, BindingResult result, Model model) {
		try {
			// エラーチェック：入力チェックNGの場合は再度入力画面に戻る
			if (result.hasErrors()) {
				// 入力エラーがある場合、入力画面に戻る
				return "input"; // 入力画面に戻る
			}

			// 確認用にフォームデータをモデルに追加
			model.addAttribute("form", form); // formをconfirmビューに渡す
			return "confirm"; // confirm.htmlビューに遷移
		} catch (Exception e) {
			// エラーが発生した場合、エラーログを出力
			e.printStackTrace(); // スタックトレースをコンソールに表示
			model.addAttribute("error", "確認画面の処理に失敗しました"); // エラーメッセージをモデルに追加
			return "error"; // error.htmlビューに遷移
		}
	}

		// 成功画面（successビュー）に遷移
		@PostMapping("/success")
		public String successForm(@ModelAttribute PresentForm form) {
		    try {
		        // フォームの送信後の処理（例: 保存など）
		        System.out.println("プレゼント番号: " + form.getPresent());  // プレゼント番号の出力
		        System.out.println("住所: " + form.getAddress());  // 住所の出力
		        return "success";  // success.htmlビューに遷移
		    } catch (Exception e) {
		        // エラーが発生した場合、エラーログを出力
		        e.printStackTrace();  // スタックトレースをコンソールに表示
		        return "error";  // error.htmlビューに遷移
		    }
		}
		
		// リスト画面（listビュー）を表示
		@GetMapping("/list")
		public String showList() {
		    try {
		        // 何らかのリストを表示するための処理
		        return "list";  // list.htmlビューに遷移
		    } catch (Exception e) {
		        // エラーが発生した場合、エラーログを出力
		        e.printStackTrace();  // スタックトレースをコンソールに表示
		        return "error";  // error.htmlビューに遷移
		    }
		} 
}
