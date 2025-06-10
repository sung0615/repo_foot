package com.aaa000.demo.user.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/member")
public class restApiController {
	
	@Autowired
	UserService userservice;
	
	// 리스트 보여주기Api
	@RequestMapping(value = "", method = RequestMethod.GET)
//	@GetMapping("")
	public List<UserDto> selectList(UserVo vo) throws Exception {
		List<UserDto> list = userservice.selectList(vo);
		return list;
	}
	
	// 데이터만 Seq 한개 저애서 보여주기
	@RequestMapping(value = "/{seq}", method = RequestMethod.GET)
//	@GetMapping("/{seq}")
	public UserDto selectOne(@PathVariable("seq") String seq, UserVo vo, UserDto userDto) throws Exception {
		userDto.setSuSeq(seq);
		UserDto item = userservice.selectOne(userDto);
		return item;
	}
	

	@RequestMapping(value = "", method = RequestMethod.POST)
//	@PostMapping("")
	public String insert(UserDto userDto) throws Exception {
		
		System.out.println("dto.getIfmmId(): " + userDto.getUserId());
		System.out.println("dto.getIfmmName(): " + userDto.getUserName());
		
		userservice.insert(userDto);
		return userDto.getSuSeq();
	}
	
	
	@RequestMapping(value = "/{seq}", method = RequestMethod.PUT)
//	@PatchMapping("/{seq}")
//	@PutMapping("/{seq}")
	public void update(@PathVariable String seq, UserDto userDto) throws Exception {
		
		
		System.out.println("seq: " + seq);
		System.out.println("dto.getIfmmId(): " + userDto.getUserId());
		System.out.println("dto.getIfmmName(): " + userDto.getUserName());
		
		userDto.setSuSeq(seq);
		userservice.update(userDto);
	}
	
}
