--1. �ڽ��� �Ŵ������� ä����(hire_date)�� ���� ����� ���(employee_id), ��(last_name)�� ä����(hire_date)�� ��ȸ�϶�.
select e1.employee_id ���, e1.last_name ��, e1.hire_date ä���� 
from EMPLOYEES e1, EMPLOYEES e2
where e1.hire_date>e2.hire_date
	and e1.manager_id = e2.employee_id;

--2. �� ���(employee)�� ���ؼ� ���(employee_id), �̸�(first_name), �μ���(department_name), 
--   �Ŵ���(manager)�� �̸�(first_name)�� ��ȸ�Ͻÿ�.
select e1.employee_id ���, e1.first_name �̸�, d.department_name �μ���, e2.first_name �Ŵ��� 
from EMPLOYEES e1, EMPLOYEES e2, DEPARTMENTS d
where e1.manager_id=e2.employee_id
		and e1.department_id=d.department_id;
		
		
--3. �� ����(job_title)�� ��� �μ�(department_name)���� ����Ǵ��� ��ȸ�ϴ� SQL �������� �ۼ��ϼ���.
--   (��, �������� �ʴ� ������ ǥ������ �ʰ� �ߺ��Ǵ� ������ �ϳ��� ǥ���մϴ�.)
select distinct job.job_title, d.department_name
from DEPARTMENTS d, EMPLOYEES e, JOBS job
where e.job_id=job.job_id and e.department_id = d.department_id
order by 1;

--4. Ư�� ����� ��� ��ȣ(employee_id)�� �ٸ� ����� ������ ��ȣ(manager_id)�� �ִ� ����� ���, �� ����� �����ڶ�� �����մϴ�. 
--�̸�(FIRST_NAME)�� "v"(�ҹ���)�� �� ����鿡 ���� ��� ��ȣ(EMPLOYEE_ID), �̸�(FIRST_NAME), ������ �̸�(�������� FIRST_NAME)�� 
--��ȸ�ϰ� �����ڰ� ���� ��쿡�� ������ �̸��� "NOT EXIST"��� ����ϵ��� SQL ������ �ۼ��ϼ���.
select e1.employee_id "��� ��ȣ", e1.first_name �̸�, nvl(e2.first_name,'NOT EXIST') "������ �̸�" 
from EMPLOYEES e1, EMPLOYEES e2
where e1.first_name like '%v%'
	  and e1.manager_id = e2.employee_id(+)
order by 1;

--5. ��� �̸��� �ش� ����� ��� �̸��� ����Ͻÿ�. �� �� ��簡 ���� ��쵵 ��µǵ��� �Ͻÿ�.
--���: ����̸� | ����̸�
--(��, �̸��� ������ first_name�� last_name�� �������� ������ �����Դϴ�.)
select e1.first_name||' '||e1.last_name, e2.first_name||' '||e2.last_name
from EMPLOYEES e1, EMPLOYEES e2
where e1.manager_id = e2.employee_id(+);








