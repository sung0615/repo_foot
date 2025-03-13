package com.aaa000.demo.user.favorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDao favoritesDao;
	
	// 리스트 보여주기
	public List<FavoritesDto> selectList(){
		return favoritesDao.selectList();
	}
	
	//업데이트 삭제
	public int uelete(FavoritesDto favoritesDto) {
		return favoritesDao.uelete(favoritesDto);
	}
}
