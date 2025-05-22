package com.aaa000.demo.user.favorites;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    // 즐겨찾기 my페이지 즐겨찾기 내역
    @GetMapping("/FavoritesUserList")
    public String FavoritesUserList(Model model, HttpSession session) {
        Integer userSeq = getUserSeqFromSession(session);
        if (userSeq == null) {
            model.addAttribute("list", null);
            return "user/favorites/FavoritesUserList";
        }
        model.addAttribute("list", favoritesService.selectListByUser(userSeq));
        return "user/favorites/FavoritesUserList";
    }

    // 즐겨찾기 토글 AJAX 처리 (추가/삭제)
    @PostMapping("/toggle")
    @ResponseBody
    public Map<String, Object> toggleFavorite(@RequestParam("fiSeq") int fiSeq, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        Integer userSeq = getUserSeqFromSession(session);
        if (userSeq == null) {
            result.put("status", "error");
            result.put("message", "로그인이 필요합니다.");
            return result;
        }

        try {
            boolean isFavorited = favoritesService.isFavorited(userSeq, fiSeq);
            if (isFavorited) {
                favoritesService.deleteFavorite(userSeq, fiSeq);
                result.put("status", "deleted");
            } else {
                favoritesService.addFavorite(userSeq, fiSeq);
                result.put("status", "added");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "서버 오류가 발생했습니다.");
        }

        return result;
    }

    private Integer getUserSeqFromSession(HttpSession session) {
        Object obj = session.getAttribute("sessSeqUser");
        if (obj == null) return null;

        if (obj instanceof Integer) {
            return (Integer) obj;
        } else if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
	
	
	
}
