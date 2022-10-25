package com.mycom.myboard.service;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

public interface BoardService {
	
	// 목록
	// 총건수를 구하는 부분이 boardList에 포함되어 있다.
	BoardResultDto boardList(BoardParamDto boardParamDto);
	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
	
	// 상세 
	BoardResultDto boardDetail(BoardParamDto boardParamDto);
	
	// 수정
	BoardResultDto boardUpdate(BoardDto boardDto);
	
	// 삭제
	BoardResultDto boardDelete(int boardId);
	
	// 삽입
	BoardResultDto boardInsert(BoardDto boardDto);


}
