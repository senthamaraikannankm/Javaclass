1. Display all the information of the EMP table.
Ans: select * from emp;

2. Display unique Jobs from EMP table.
ans: select empno,ename,sal as salary,job,deptno,comm from emp order by job desc;

3. Display the details of all MANAGERS.
Ans: select * from emp where job='MANAGER';

4. List the emps who joined before 1981.
Ans: select *  from emp where EXTRACT( YEAR FROM TO_DATE(hiredate,  'DD-MM-YYYY' ) ) < 81
 

5. Display the Empno, Ename, Job, Hiredate, and experience of all Managers.
Ans: select Empno, Ename, Job, Hiredate,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))
as experience  from emp where job='MANAGER';

6. List the Empno, Ename, Sal, Exp of all emps working for Mgr 7639.
Ans: select empno, ename,mgr, sal,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))as experince from emp where mgr='7839';

7. Display all the details of the emps whose Comm. Is more than their Sal.
Ans:select * from emp where comm > sal;

8. List the emps along with their Exp and whose Daily Sal is more than Rs. 100.
Ans: select empno, ename,mgr, sal,TO_NUMBER(TO_CHAR(TO_DATE(Hiredate, 'DD-MM-YY'), 'YYYY'))-TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))as experince from emp
where(sal/30)>100;

9. List the emps who are working for the Deptno 10 or 20.
Ans: select * from emp where deptno in(10,20);

10. List the emps who are working under any Manager.
Ans: select ename,job,sal,hiredate,mgr from emp where mgr in (select empno from emp) order by mgr;

11. List all the Clerks of Deptno 20.
Ans: select * from emp where deptno=20 and job='CLERK';

12. Display the details of SMITH.
Ans: select * from emp where ename='SMITH';

13. Display the Empno, Ename, Deptno from EMP table.
select empno,ename,deptno from emp;

14. Write a query to display the Empno and the Deptno of all emps.
select empno ,deptno from emp;

15. Display the unique Depts of emps.
select distinct deptno from emp;

16. List the emps whose Salary is more than 3000 after giving 20% increment.
select empno,ename,sal,(sal+(sal*0.20))as sal_20 from emp where (sal+(sal*0.20)) >3000;

17. List the Ename and Sal increased by 15% and expressed as No. of Dollars.
select ename,to_char(sal,'$99,999.000') as sal,to_char((sal+(sal*0.15)),'$99,999.000')as sal_15 from emp;

18. Produce the output of EMP table EMP_AND_JOB for Ename and job.
select ENAME || ' and '|| JOB from emp;

19. Display the Empno, Ename, Salary of all Managers.
select empno,ename,sal from emp where job='MANAGER';

20. Define a variable representing the expression used to calculate on emps total annual remuneration use the variable in a statement which finds all emps who can earn 30000 a year or more.
select empno,ename,sal,comm,annual from(
select empno,ename,sal,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual from emp
)where annual >=30000;

21. Check whether all the emps numbers are indeed unique.
select COUNT(distinct empno)from emp;

21. Check whether all the emps numbers are indeed unique.
select empno, COUNT(empno)from emp group by empno having  COUNT(empno)>1

22. List the Empno, Sal and Comm of emps.
select empno,sal,comm from emp;


23. Display the unique dept with Jobs.
select distinct job,deptno from emp; 

24. Display the details of Blake.
select * from emp where ename='BLAKE';

25. List all Clerks.
select * from emp where job='CLERK';

26. List all emps joined on 1 may 1981.
select * from emp where hiredate>=to_date('01 may 1981','dd-mm-yyyy');

27. List the emps whose Salaries are less than 3500.
select empno,ename,sal as salary from emp where sal<3500;

28. List the emps Empno, Ename, Sal of all emp joined before 1 Apr 1981.
select empno,ename,sal from emp where hiredate < to_date('1 April 1982','DD Month YYYY');

29. List the emps whose exp is more than 10 years.
select empno,ename,sal,hiredate from emp where experience >10;

30. List the emps who are working as Manager.
select * from emp where job='MANAGER';

31. List the emps who are working as clerks and exp is more that 8 Years.
select * from emp where job='CLERK' and experience>8;

32. List the Empno, Ename, Sal, Job of emps with the annSal <34000 but receiving some comm. Which should not be greater than Sal and the designation should be Salesman working for dept 20.
select empno,ename,sal,job,annual,deptno,comm from(
select empno,ename,sal,job,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual,deptno from emp
)
where annual<34000 and deptno=20 and job='SALESMAN' and comm>0 and comm<sal;

33. List all the Salesmen who are receiving Comm.
select * from emp where job='SALESMAN' and comm>0;

34. List all the Salesmen of the Dept 30 whose Comm. Is more than their Salary.
select * from emp where job='SALESMAN' and deptno=30 and comm>sal;

35. Generate all the 3 digit numbers.


SELECT * FROM emp where ename is not null and rownum between 1 and 5;

36. Display the first 5 records of the EMP table.
select * from emp where ROWNUM <=5;

37. List the emps empno, ename, job, sal of all emps.
select empno,ename,job,sal from emp;

38. List all the unique deptno of emps.
select distinct deptno from emp;

39. List all the unique jobs along with deptno.
select distinct job,deptno from emp;

40. List all the details of ‘Miller’.
select * from emp where ename='MILLER';

41. list the details of dept 10.
select * from emp where deptno=10;

42. List all the ‘SALESMAN’.
select * from emp where job='SALESMAN';

43. List all the emps who joined before 1984.
select * from emp where hiredate<'01-01-84';

44. List all the emps whose Sal>2500.
select * from emp where sal>2500;

45. List all the emps who are working since 1st April 1982.
select * from emp where hiredate >=to_date('1 April 1982','DD Month YYYY');

46. List the empno, ename, sal, Daily sal of all emps.
select empno,ename,sal,trunc((sal/30),2) as daily_sal from emp;

47. List the empno, ename, sal, experience of all ‘Analysts’.
select empno,ename,sal,experience from emp where job='ANALYST';

48. List the emps whose exp>6.5 Y.
select * from emp where EXTRACT(YEAR FROM age(CURRENT_DATE, hiredate)) > 6.5;

49. List the emps who joined in 2nd half of 1981.
select * from emp where HIREDATE<'31-12-1981' and HIREDATE > '01-06-1981';

50. List all the emps in dept 10 who are working as Clerks.
select * from emp where deptno=10 and job='CLERK';

51. List the emps who joined before 1985 and salary is more than 3000.
select * from emp where HIREDATE<'01-01-1985' and sal > 3000;