<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
	<h1> DB Test ( using JSON )</h1>
	<button id="btnEmpDetail">Emp 상세</button>
	<button id="btnEmpList">Emp 목록</button>
	<br>
	<button id="btnEmpInsert">Emp 등록</button>
	<button id="btnEmpDelete">Emp 삭제</button>
	<button id="btnEmpUpdate">Emp 수정</button>
	
	
	<script>
	window.onload = function() {
		document.querySelector("#btnEmpDetail").onclick = async function() {
			
			try {
				let response = await fetch('/mydb/empDetail/1500');
				let data = await response.json();
				console.log(data);
			} catch(error) {
				console.error(error)
			}
			
		}
		
		
	document.querySelector("#btnEmpList").onclick = async function() {
			
			try {
				let response = await fetch('/mydb/empList');
				let data = await response.json();
				console.log(data);
			} catch(error) {
				console.error(error)
			}
			
		}
	
	// javascript 객체
	var empInsertData = {
		employeeId: 1600,
		firstName: '유',
		lastName: '길동',
		email: 'you@gildong.com',
		hireDate: '2022-10-20'
	}
	
	document.querySelector("#btnEmpInsert").onclick = async function() {
		
		let urlParams = new URLSearchParams( empInsertData );
		let fetchOptions = {
			method: 'POST', 
			body: urlParams
		}
		
		try {
			let response = await fetch('/mydb/empInsert', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch(error) {
			console.error(error)
		}
		
	}
	

	document.querySelector("#btnEmpDelete").onclick = async function() {
		
		let urlParams = new URLSearchParams( {employeeId: 1600} );
		let fetchOptions = {
			method: 'POST', 
			body: urlParams
		}
		
		try {
			let response = await fetch('/mydb/empDelete', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch(error) {
			console.error(error)
		}
		
	}
		
	var empUpdateData = {
			employeeId: 1600,
			firstName: '길동씨',
			lastName: '김',
			email: 'kim@gildong.com',
			hireDate: '2022-10-25'
		}
	
	document.querySelector("#btnEmpUpdate").onclick = async function() {
		
		let urlParams = new URLSearchParams( empUpdateData );
		let fetchOptions = {
			method: 'POST', 
			body: urlParams
		}
		
		try {
			let response = await fetch('/mydb/empUpdate', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch(error) {
			console.error(error)
		}
		
	}
	
	
	
	}
	</script>
</body>
</html>
