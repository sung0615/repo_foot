package com.aaa000.demo.user.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	// 사용자 리스트보여주기
	public List<UserDto> selectList(){
		return userDao.selectList();
	}
	
	//데이터 1개씩 뽑기
	public UserDto selectOne(UserDto userDto) {
		return userDao.selectOne(userDto);
	}
	
	// 등록하기
	public int insert(UserDto userDto) {
		return userDao.insert(userDto);
	}
	
	// 수정하기
	public int update(UserDto userDto) {
		return userDao.update(userDto);
	}
	
	// 업데이트 삭제
	public int uelete(UserDto userDto) {
		return userDao.uelete(userDto);
	}
	
}
