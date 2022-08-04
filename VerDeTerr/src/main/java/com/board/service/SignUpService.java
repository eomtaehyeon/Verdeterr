package com.board.service;

import org.springframework.stereotype.Service;

import com.board.domain.UserDTO;


@Service
public interface SignUpService {

	public int signUp(UserDTO params);
	
	public String checkId(String id);
	
	public int delete(UserDTO params);
	
}
