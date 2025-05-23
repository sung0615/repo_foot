package com.aaa000.demo.user.favorites;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesDao {
	
    List<FavoritesDto> selectList();

    List<FavoritesDto> selectListByUser(@Param("suSeq") int suSeq);

    int countFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);

    int insertFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);

    int deleteFavorite(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);
    
    
    int getFavoriteStatus(int suSeq, int fiSeq);
    
    
    int selectFavoriteStatus(@Param("suSeq") int suSeq, @Param("fiSeq") int fiSeq);
	
}
