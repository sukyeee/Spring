package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;

// dao layer 는 Controller, Service 를 바라보고 코드를 작성 X, DB 등 Persistance 를 보고 작성 
@Mapper
public interface BoardDao {
	
	// 목록 
	// limit, offset
	List<BoardDto> boardList(BoardParamDto boardParamDto);
	int boardListTotalCount();
	
	// searchWord
	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
	
	// 상세 
	BoardDto boardDetail(BoardParamDto boardParamDto);
	
	// 등록
	int boardInsert(BoardDto dto); // 게시글 등록 
	int boardFileInsert(BoardFileDto dto); // 첨부파일 등록
	
	// 수정
	int boardUpdate(BoardDto dto);
	
	// 삭제
	int boardDelete(int boardId);

	void boardFileDelete(int boardId);
	List<String> boardFileUrlDeleteList(int boardId);
}
