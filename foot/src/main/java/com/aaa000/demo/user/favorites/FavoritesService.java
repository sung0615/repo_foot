package com.aaa000.demo.user.favorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa000.demo.module.base.BaseService;

@Service
public class FavoritesService extends BaseService{
	
	@Autowired
	FavoritesDao favoritesDao;
	
    @Autowired
    public void FavoritesServiceImpl(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }
    
    //즐겨찾기 리스트
    public List<FavoritesDto> favoritesList(int suSeq){
    	return favoritesDao.favoritesList(suSeq);
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
    
	// 업데이트 삭제
	public int uelete(List<String> deleteIds) {
		return favoritesDao.uelete(deleteIds);
	}
	
	
}
