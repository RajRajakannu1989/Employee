package com.onesoft.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String addAllEmployees(List<Employee> emps) {
		return empDao.addAllEmployees(emps);
	}

	public Employee findOneValue(int ob) {
		return empDao.findOneValue(ob);
	}

	public List<Employee> getList() {
		return empDao.getList();
	}

	public String deleteValue(int d) {
		// TODO Auto-generated method stub
		return empDao.deleteValue(d);
	}

	public String putEmployee(Employee e) {
		return empDao.putEmployee(e);
	}

	public List<Employee> getByGender(String gender) {
		List<Employee> allEmp = empDao.getList();
		List<Employee> li = allEmp.stream().filter(s -> s.getGender().equalsIgnoreCase(gender)).toList();
		return li;
	}

	public List<Employee> getByName(String name) {
		List<Employee> allEmp = empDao.getList();
		List<Employee> li = allEmp.stream().filter(s -> s.getName().equalsIgnoreCase(name)).toList();
		return li;
	}

	public List<Employee> getBySalary(int salary) {
		List<Employee> allEmp = empDao.getList();
		List<Employee> li = allEmp.stream().filter(s -> s.getSalary() > salary).toList();
		return li;
	}

	public List<Employee> getEmpBySalary(int sal1, int sal2) {

		return empDao.getEmpBySalary(sal1, sal2);
	}

	public List<Employee> getByServiceName(String name) {
		return empDao.getByDaoName(name);
	}

	public List<Employee> incrementGender() {
		List<Employee> increEmp = empDao.getList();
		List<Employee> incre = increEmp.stream().map(e -> {
			if (e.getGender().equalsIgnoreCase("female")) {
				e.setSalary((e.getSalary() * 5/100)+e.getSalary());
			}
			return e;
		}).collect(Collectors.toList());
		return incre;
	}

	public String addExcepEmployee(Employee e) throws AgeNotFoundException {
		try {
		if(e.getAge()<18) {
			throw new AgeNotFoundException();
			
		}
		else {
			return empDao.addExcepEmployee(e);
		}
	}
		catch(AgeNotFoundException ae){
			return "Your age is not valid";
			}
		}

	
	public Employee idNotAvailable(int id) throws EmployeeNotFoundException {
		
		return empDao.idNotAvailable(id);
	}

	public List<Employee> nameNotAvailable(String name) throws NameNotFoundException {
		List<Employee> emp=empDao.getList();
		List<Employee> e=emp.stream().filter(s->s.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if(e.isEmpty()) {
			throw new NameNotFoundException();
		}
		return e;
	}

	public Employee change(int id, Employee s) {
		
		return empDao.change(id, s);
	}

	public Employee modify(int id, Employee m) {
		return empDao.modify(id, m) ;
	}
	

}
