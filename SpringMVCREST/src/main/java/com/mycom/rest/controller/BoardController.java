package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.BoardDto;

@RestController
public class BoardController {

		Date now = new Date();

		// 이벤트 목록 => GET /boards
		@GetMapping(value="/boards")
		public List<BoardDto> boardList() {
			System.out.println("GET /boards");
			List<BoardDto> list = new ArrayList<>();
			return list; // json
		}
		
		// totalCnt => GET /boards
		@GetMapping(value="/boards/{searchWord}")
		public int boardListTotalCnt(@PathVariable String searchWord) {
			System.out.println("GET /boards");
			return 1; 
		}
		
		// 상세 => GET /boards/123
		@GetMapping(value="/boards/{boardId}")
		public BoardDto boardDetail(@PathVariable int boardId) {
			System.out.println("GET /boards/" + boardId);
			return new BoardDto(2, "name", now,  now, "event1.html", "100", "sk",  now, true);
		}
		
		// 등록 => POST /boards
		@PostMapping(value="/boards")
		public int boardInsert(BoardDto dto) {
			return 1;
		}
		
		// 삭제 => DELETE /boards/123
		@DeleteMapping(value="/boards/{boardId}")
		public int boardDelete(@PathVariable int boardId) {
			return 1;
		}
		
		// 수정 => PUT /boards/123
		@PutMapping(value="/boards/{boardId}")
		public int boardUpdate(@PathVariable int boardId, BoardDto dto) {
			return 1;
		}
		
		// Customer에게 보이는 목록 => GET /customer/boards
		@GetMapping(value="/customer/boards")
		public List<BoardDto> boardListCustomer() {
			System.out.println("GET /customer/boards");
			List<BoardDto> list = new ArrayList<>();
			return list; // json
		}
		
		// Customer에게 보이는 page => GET /customer/boards/{boardId}
		@GetMapping(value="/customer/boards/{boardId}")
		public BoardDto boardPage() {
			return new BoardDto(2, "name", now,  now, "event1.html", "100", "sk",  now, true);
		}
		
		// Customer를 boardAttend 테이블에 추가  => POST /customer/boards
		@PostMapping(value="/customer/boards")
		public int boardAttend(BoardDto dto) {
			return 1;
		}
		
		
		
}
