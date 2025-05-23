package com.aaa000.demo.user.favorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDao favoritesDao;
	
    @Autowired
    public void FavoritesServiceImpl(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    public List<FavoritesDto> selectListByUser(int suSeq) {
        return favoritesDao.selectListByUser(suSeq);
    }

    public void addFavorite(int suSeq, int fiSeq) {
        favoritesDao.insertFavorite(suSeq, fiSeq);
    }

    public void deleteFavorite(int suSeq, int fiSeq) {
        favoritesDao.deleteFavorite(suSeq, fiSeq);
    }

    // 0: 즐겨찾기 됨, 1: 즐겨찾기 안됨 (없으면 기본값 1)
    public int getFavoriteStatus(int suSeq, int fiSeq) {
        Integer status = favoritesDao.selectFavoriteStatus(suSeq, fiSeq);
        return (status != null) ? status : 1;
    }
	
	
}
