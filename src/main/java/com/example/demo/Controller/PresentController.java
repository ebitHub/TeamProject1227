package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Enpresent;  // エンティティ名は Enpresent のまま
import com.example.demo.service.PresentService;

@Controller
public class PresentController {

	 @Autowired
	    private PresentService presentService;  // サービスのインスタンスを@Autowiredでインジェクト

	    // 1. Index (トップ画面)
	    @GetMapping("/")
	    public String showIndex() {
	        return "index";  // index.htmlを表示
	    }

	    // プレゼントの入力と住所の入力を受け取る
	    @PostMapping("/request")
	    public String processRequest(@ModelAttribute Enpresent request, Model model) {
	        model.addAttribute("request", request);  // 入力データを確認画面に渡す
	        return "confirm";  // confirm.htmlへ遷移
	    }

	    // 2. Confirm (確認画面)
	    @PostMapping("/submit")
	    public String submitRequest(@ModelAttribute Enpresent request) {
	        // インスタンスメソッドとして呼び出し
	        presentService.savePresent(request); // プレゼントのリクエストをデータベースに保存
	        return "success"; // success.htmlへ遷移
	    }
	

    // 3. Success (完了画面)
    @GetMapping("/success")
    public String showSuccess() {
        return "success";  // success.htmlを表示
    }

    // 4. List (管理者用リスト画面)
    @GetMapping("/list")
    public String showRequestList(Model model) {
        List<Enpresent> requests = presentService.getAllRequests();  // 修正: `enpresentService` を `presentService` に変更
        model.addAttribute("requests", requests);  // リストをビューに渡す
        return "list";  // list.htmlを表示
    }

    // 5. 戻るボタンの処理 (確認画面から戻る)
    @GetMapping("/back")
    public String goBackToIndex() {
        return "index";  // 入力画面に戻る
    }
}
