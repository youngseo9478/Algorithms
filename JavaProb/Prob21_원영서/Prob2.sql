1. �� ����(job) ���� ����(salary)�� ������ ���ϰ��� �Ѵ�. 
   ���� ������ ���� ���� �������� ������(job_title)�� ���� ������ ��ȸ�Ͻÿ�.

select job_title ������, sum(salary) "���� ����"
from employees e, jobs j
where j.job_id = e.job_id
group by e.job_id, j.job_title
order by "���� ����" desc;

2. �� �� �Ի��� ���� ��ȸ�ϴ� SQL �������� �ۼ��ϼ���. �� ������ �����ϼ���. 
   (���: �� | �Ի��ڼ�)

select to_char(hire_date,'mm') "��", count(employee_id) 
from employees
group by to_char(hire_date,'mm')
order by ��;

3. ���ø�(city)�� 'Southlake'�� ������ �ٹ��ϴ� ���� �߿� ������ ���� ���� �޴� 
   ������ ���(employee_id), �̸�(first_name), ����(salary)�� ����Ͻÿ�.

   select employee_id, first_name, salary
   from(select * from employees e, departments d, locations l
   		where e.department_id = d.department_id
   		and d.location_id = l.location_id
   		and l.city = 'Southlake')
   where rownum = 1;
   


4. �μ� �̸�(department_name) �� �������� ��տ���(salary) �� ��ȸ�Ͻÿ�.
��, ��30���� �μ��� ���� ��� �������� ��� ������ ������ �μ� ������ ��µǾ�� �մϴ�. 

select d.department_name, avg(e.salary)
from departments d, employees e
where d.department_id = e.department_id
having avg(e.salary)<=(select avg(e2.salary)
					from departments d2, employees e2
					where d2.department_id = 30
					and d2.department_id = e2.department_id)
group by d.department_name;

