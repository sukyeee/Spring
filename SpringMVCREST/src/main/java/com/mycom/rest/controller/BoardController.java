package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.BoardDto;
import com.mycom.rest.dto.StudentDto;

@RestController
public class BoardController {

	
		// 이벤트 목록 => GET /boards
		@GetMapping(value="/boards")
		public List<BoardDto> list() {
			System.out.println("GET /boards");
			List<BoardDto> list = new ArrayList<>();
			return list; // json
		}
		
		// totalCnt => GET /boards
		@GetMapping(value="/boards")
		public int listTotalCnt() {
			System.out.println("GET /boards");
			return 1; 
		}
		

		// 상세 => GET /boards/123
		@GetMapping(value="/boards/{boardId}")
		public BoardDto detail(@PathVariable int boardId) {
			System.out.println("GET /boards/" + boardId);
			return new BoardDto(222, "aaa", "a", "a");
		}
		
		// 등록 => POST /boards
		@PostMapping(value="/boards")
		public int insert(BoardDto dto) {
			
			return 1;
		}
		
		// 삭제 => DELETE /boards/123
		@DeleteMapping(value="boards/{boardId}")
		public int delete(@PathVariable int boardId) {
			return 1;
		}
		
		// 수정 => PUT /boards/123
		@PutMapping(value="boards/{boardId}")
		public int update(@PathVariable int boardId, BoardDto dto) {
			return 1;
		}
		
		// Customer에게 보이는 목록 => GET /boards
		@GetMapping(value="/boards")
		public List<BoardDto> listCustomer() {
			System.out.println("GET /boards");
			List<BoardDto> list = new ArrayList<>();
			return list; // json
		}
		
		// Customer에게 보이는 page 
		@GetMapping(value="/boards")
		public BoardDto getPage() {
			return new BoardDto(333, "aaa", "a", "a");
		}
		
		// 등록 => POST /boards
		@PostMapping(value="/boards")
		public int boardAttend(BoardDto dto) {
			return 1;
		}
		
		
		
}
