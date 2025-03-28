package com.aaa000.demo.user.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	
	//회원 가입 폰 리스트
	public List <UserDto> codeList (UserDto userDto);
	
	// 관리자 로그인 비교
	public UserDto selectId(UserDto userDto);
	
	// 사용자 리스트 보여주기
	public List <UserDto> selectList(UserVo vo);
	
	//데이터 1개만 뽑을때
	public UserDto selectOne(UserDto userDto);
	
	//사용자 등록폼
	public int insert(UserDto userDto);
	
	//사용자 수정하기
	public int update(UserDto userDto);
	
	//사용자 업데이트 삭제
	public int uelete(UserDto userDto);
	
	public int selectOneCount(UserVo vo);
}
