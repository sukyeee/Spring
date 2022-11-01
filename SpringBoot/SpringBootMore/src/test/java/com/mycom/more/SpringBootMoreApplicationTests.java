package com.mycom.more;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@SpringBootTest
class SpringBootMoreApplicationTests {

	@Autowired
	StudentService service;
	
	// test method 를 생성해서 테스트를 진행하려고 하는데, StudentService 객체 <= DI
	// StudentService 객체가 DI 가 잘 되는지 테스트
	// StudentService 를 이용해서 신규로 등록 1건 테스트 
	
	@Test
	void testService() {
		assertNotNull(service);
	}
	
	@Test
	void testInsert() {
		
		// 프론트엔드 화면 개발x
		// insert process 에 대한 테스트 
		
		StudentDto dto = new StudentDto();
		dto.setStudentNm("박길덩");
		dto.setEmail("park@gildong.com");
		dto.setPhone("010-5555-5555");
		assertEquals(1, service.insert(dto));
		
	}

	
	// #1. 아직 완료되지 않은 프론트에 종속적이지 않게 테스트를 진행
	// #2. Controller -> Service -> Dao 혹은 다른 레이어 의 메소드 단위로 테스트 가능 
	// #3. 레거시 시스템의 input / output 결과와 현재 신시스템의 input / output 개발 결과 비교/검증
	// #4. 독립적으로 @Transactional 통해 tx 관리도 가능
	
}



