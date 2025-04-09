package com.aaa000.demo.user.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	// 회원가입 아이디 비교
	public int idDuplicate(UserDto userDto) {
		return userDao.idDuplicate(userDto);
	}
	
	
	// 관리자 ID 
	public UserDto selectId(UserDto userDto){
		return userDao.selectId(userDto);
	}
	
	//사용자 리스트 회원 가입
	public List<UserDto> codeList(UserDto userDto){
		return userDao.codeList(userDto);
	}
	
	// 사용자 리스트보여주기
	public List<UserDto> selectList(UserVo vo){
		return userDao.selectList(vo);
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
	//my페이지 비밀번호 수정
	public int updatePassword(UserDto userDto) {
		return userDao.updatePassword(userDto);
	}
	
	
	// 업데이트 삭제
	public int uelete(UserDto userDto) {
		return userDao.uelete(userDto);
	}
	
	//페이지 네이션
	public int selectOneCount(UserVo vo) {
		return userDao.selectOneCount(vo);
	}
	
	
	
	
	
}
