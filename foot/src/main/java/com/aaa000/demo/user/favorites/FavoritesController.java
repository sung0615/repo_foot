package com.aaa000.demo.user.favorites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FavoritesController {
	
	
	@Autowired
	FavoritesService favoritesService;
	
	// 즐겨찾기 my페이지 즐겨찾기 내역에 뿌려주기
	@RequestMapping(value="/FavoritesUserList")
	public String FavoritesUserList(Model model) {
		model.addAttribute("list", favoritesService.selectList());
		return "user/favorites/FavoritesUserList";
	}
}
