package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PresentEntity;
import com.example.demo.form.LoginForm;
import com.example.demo.form.PresentForm;
import com.example.demo.mapper.PresentMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PresentController {

	// DI
	private final PresentMapper presentMapper;

	//**「form back bean」の初期化
	@ModelAttribute
	public PresentForm setUpForm() {
		return new PresentForm();
	}

	/* 入力画面を表示する */
	@GetMapping("/input")
	public String showview() {
		return "input";
	}

	// フォームが送信された後にコンソールに入力内容を表示
	//バリデーションチェック
	@PostMapping("/confirm")
	public String input_check(@Validated PresentForm form,BindingResult bindingResult, Model model) {
		//入力チェック
		if (bindingResult.hasErrors()) {
			// エラーがあった場合、入力画面へ戻す
			return "input";
		}

		/* 入力された数字に対応したプレゼント名をModelに追加する */
		// 入力されたpresent_idを取得
		int presentId = form.getPresent();
		// present_idに対応するnameを取得
		model.addAttribute("present_name", presentMapper.getPresentName(presentId));

		//入力チェックおk
		// エラーがなければconfirm画面に遷移
		model.addAttribute("form", form);
		return "confirm";
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


		// 登録成功メッセージを追加
		model.addAttribute("message", "登録成功！リクエスト完了");
		/* 確認用 */
		// フォームの送信後の処理（例: 保存など）
		//				System.out.println("プレゼント番号: " + form.getPresent());  // プレゼント番号の出力
		//				System.out.println("住所: " + form.getAddress());  // 住所の出力

		return "success";  // success.htmlビューに遷移
	}

	// リスト画面（listビュー）を表示
	//「http://localhost:8080/list」でアクセス
	@GetMapping("/list")
	public String showList(Model model) {
		model.addAttribute("present_list",presentMapper.getAllPresentEntities());
		model.addAttribute("present_counts", presentMapper.getPresentCounts());
		return "list";
	} 

	//サンタ専用メニュー画面
	@GetMapping("/santaMenu")
	public String showSantaMenu(){
		return "santa_menu";
	}

	//ログイン画面
	@GetMapping("/login")
	public String showLogin(@ModelAttribute LoginForm form) {
		// templatesフォルダ配下のlogin.htmlに遷移
		return "login";
	}
}
