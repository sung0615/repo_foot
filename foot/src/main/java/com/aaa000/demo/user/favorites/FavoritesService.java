package com.aaa000.demo.user.favorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDao favoritesDao;
	
    public void FavoritesServiceImpl(FavoritesDao favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    public List<FavoritesDto> selectListByUser(int suSeq) {
        return favoritesDao.selectListByUser(suSeq);
    }

    public boolean isFavorited(int suSeq, int fiSeq) {
        int count = favoritesDao.countFavorite(suSeq, fiSeq);
        return count > 0;
    }

    @Transactional
    public void addFavorite(int suSeq, int fiSeq) {
        favoritesDao.insertFavorite(suSeq, fiSeq);
    }

    @Transactional
    public void deleteFavorite(int suSeq, int fiSeq) {
        favoritesDao.deleteFavorite(suSeq, fiSeq);
    }
	
	
}
