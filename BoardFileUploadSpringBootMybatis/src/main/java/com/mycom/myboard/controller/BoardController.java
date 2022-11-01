package com.mycom.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;
import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.service.BoardService;

// Client의 요청에 대해 파라미터 처리를 담당하고 그것을 처리할 적정한 Service layer 의 모듈을 찾아서 호출하고 결과를 Client에 보내준다.
@RestController
public class BoardController {
	
	@Autowired
	BoardService service;
	
	private final int SUCCESS = 1;
	
	// limit, offset, searchWord
	@GetMapping(value="/boards")
	private ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto){
		BoardResultDto boardResultDto;
		System.out.println(boardParamDto);
		
		// service 호출할 때, searchWord 유무에 따라 분리해서 처리 
		if( boardParamDto.getSearchWord() == null || boardParamDto.getSearchWord().isEmpty() ) {
			boardResultDto = service.boardList(boardParamDto);
		} else {
			boardResultDto = service.boardListSearchWord(boardParamDto);
		}
		
		if( boardResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(value="/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardDetail(@PathVariable int boardId, HttpSession session ){
		
		BoardParamDto boardParamDto = new BoardParamDto();
		boardParamDto.setBoardId(boardId); //PathVariable 로 넘어온 게시글 key
		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
		boardParamDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq
		
		BoardResultDto boardResultDto = service.boardDetail(boardParamDto);
		if( boardResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// @PutMapping 은 SpringMVC 에서는 only JSON request 에 대해서만 가능 
	// 파일 업로드 기능이 추가되면 어차피 POST 요청으로 수정 요청을 처리해야 함. <= 파일업로드 기능 자체가 PUT Request 로 되지 않음.
	// 그래서 POST 로 그대로 구현 
	@PostMapping(value="/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardUpdate( BoardDto boardDto, MultipartHttpServletRequest request ){
		
		BoardResultDto boardResultDto = service.boardUpdate(boardDto, request);
		if( boardResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@DeleteMapping(value="/boards/{boardId}")
	private ResponseEntity<BoardResultDto> boardDelete(@PathVariable int boardId ){
		
		BoardResultDto boardResultDto = service.boardDelete(boardId);
		if( boardResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/boards")
	private ResponseEntity<BoardResultDto> boardInsert( BoardDto boardDto, MultipartHttpServletRequest request ){
		
		System.out.println(boardDto);
		// 현재 사용자의 userSeq를 session에서 획득, 전달
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto"); // 현재 로그인되어서 상세 요청을 한 사용자 정보
		boardDto.setUserSeq(userDto.getUserSeq()); // 사용자 seq
		
		BoardResultDto boardResultDto = service.boardInsert(boardDto, request);
		
		
		if( boardResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
