package com.mycom.more.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CORSTestController {

	@GetMapping("/getcors")
	public ResponseEntity<Map<String, String>> getCORS(String param){
		System.out.println("getCORS : param : " + param );
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@PostMapping("/postcors")
	public ResponseEntity<Map<String, String>> postCORS(String param){
		System.out.println("postCORS : param : " + param );
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@PutMapping("/postcors/{num}")
	public ResponseEntity<Map<String, String>> putCORS(@PathVariable int num){
		System.out.println("putCORS : param : " + num );
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecors/{num}")
	public ResponseEntity<Map<String, String>> deleteCORS(@PathVariable int num){
		System.out.println("deleteCORS : param : " + num );
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
}
