package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PresentEntity;
import com.example.demo.form.PresentForm;
import com.example.demo.mapper.PresentMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PresentController {

	// DI
	private final PresentMapper presentMapper;
	
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
		public String successForm(@ModelAttribute PresentForm form, Model model) {

			/* SQLへのデータ登録 */
			// エンティティのインスタンスを生成
			PresentEntity pe = new PresentEntity();
			// 生成したインスタンスにForm内の要素を代入
			pe.setAddress(form.getAddress());
			pe.setPresent(form.getPresent());
			// 主キーはここでは指定しない（マッパーファイルのカラムで処理）
			
			// マッパーインターフェースにエンティティを渡す
			presentMapper.insertPresentEntity(pe);
			
				/* 確認用 */
				// フォームの送信後の処理（例: 保存など）
				System.out.println("プレゼント番号: " + form.getPresent());  // プレゼント番号の出力
				System.out.println("住所: " + form.getAddress());  // 住所の出力
			
			return "success";  // success.htmlビューに遷移
		}
		
		// リスト画面（listビュー）を表示
	    //「http://localhost:8080/list」でアクセス
		@GetMapping("/list")
		public String showList(Model model) {
		    model.addAttribute("present_list",presentMapper.getAllPresentEntities());
		    return "list";
		} 
}
