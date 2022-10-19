SELECT * FROM my_db.emp;

select employeeId, first_name, last_name, email, hiredate
from emp where employeeId = 1500;

delete from emp where employeeId = 1600;

update emp set first_name = "길동" where employeeId = 1500;
SELECT * FROM my_db.emp;