package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void testOfInsert() {
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");
		params.setPostType("분석가형");

		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	public void testOfSelectDetail() {
		BoardDTO board = boardMapper.selectBoardDetail((long) 2);
		try {
			//String boardJson = new ObjectMapper().writeValueAsString(board);
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

			System.out.println("=========================");
			System.out.println(boardJson);
			System.out.println("=========================");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	   public void testOfUpdate() {
	      BoardDTO params = new BoardDTO();
	      params.setTitle("3번 게시글 제목을 수정합니다.");
	      params.setContent("3번 게시글 내용을 수정합니다.");
	      params.setWriter("홍길동");
	      params.setIdx((long) 3);
	      int result=boardMapper.updateBoard(params);
	      if (result == 1) {
	         BoardDTO board = boardMapper.selectBoardDetail((long) 3);
	         try {
	            //String boardJson = new ObjectMapper().writeValueAsString(board);
	                String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

	            System.out.println("=========================");
	            System.out.println(boardJson);
	            System.out.println("=========================");

	         } catch (JsonProcessingException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	
	@Test
	  public void testOfRestore() {
	      BoardDTO params = new BoardDTO();
	      for(int i=1;i<=20;i++) 
	      {
	         int result=boardMapper.restore(params);
	         params.setIdx((long) i);
	         System.out.println(result);
	      
	      }
	}
	
	@Test
	public void testOfDelete() {
		int result = boardMapper.deleteBoard((long) 2);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long) 2);
			try {
				//String boardJson = new ObjectMapper().writeValueAsString(board);
                String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testMultipleInsert() {
		for (int i = 3; i <= 50; i++) {
			BoardDTO params = new BoardDTO();
			params.setTitle(i + "번 게시글 제목");
			params.setContent(i + "번 게시글 내용");
			params.setWriter(i + "번 게시글 작성자");
			params.setPostType("관리자형");
			boardMapper.insertBoard(params);
		}
	}
	
//	@Test
//	public void testSelectList() {
//		BoardDTO params = new BoardDTO();
//		params.setPostType("관리자형");
//		int boardTotalCount = boardMapper.selectBoardTotalCount(params);
//		if (boardTotalCount > 0) {
//			List<BoardDTO> boardList = boardMapper.selectBoardList(params);
//			if (CollectionUtils.isEmpty(boardList) == false) {
//				for (BoardDTO board : boardList) {
//					System.out.println("=========================");
//					System.out.println(board.getTitle());
//					System.out.println(board.getPostType());
//					System.out.println(board.getContent());
//					System.out.println(board.getWriter());
//					System.out.println("=========================");
//				}
//			}
//		}
//	}

}