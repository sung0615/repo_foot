package com.aaa000.demo.user.favorites;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesDao {
	
	// 리스트 보여주기
	public List<FavoritesDto> selectList();
	
	// 업데이트 삭제
	public int uelete(FavoritesDto favoritesDto);
}
