package com.aaa000.demo.user.favorites;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.aaa000.demo.module.base.BaseDao;

@Repository
public interface FavoritesDao extends BaseDao{
	
    List<FavoritesDto> selectList();

    List<FavoritesDto> selectListByUser(@Param("suSeq") int suSeq);
    
    List<FavoritesDto> favoritesList(@Param("suSeq") int suSeq);

    int countFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);

    int insertFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);

    int deleteFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);
    
    
    int getFavoriteStatus(int suSeq, int fiSeq);
    
    
    Integer selectFavoriteStatus(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);
    
	// 리뷰 업데이트 삭제
	public int uelete(List<String> deleteIds);
	
}
