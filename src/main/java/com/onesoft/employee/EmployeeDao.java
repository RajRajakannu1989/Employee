package com.onesoft.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}

	public String addAllEmployees(List<Employee> emps) {
		empRepo.saveAll(emps);
		return "Successfully added";
	}

	public Employee findOneValue(int ob) {
		return empRepo.findById(ob).get();

	}

	public List<Employee> getList() {
		return empRepo.findAll();
	}

	public String deleteValue(int d) {

		empRepo.deleteById(d);
		return "Successfully Deleted";

	}

	public String putEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully Updated";
	}

	public List<Employee> getEmpBySalary(int sal1, int sal2) {

		return empRepo.getBySalary(sal1, sal2);
	}

	public List<Employee> getByDaoName(String name) {

		return empRepo.getByName(name);
	}

	public String addExcepEmployee(Employee e) {
		empRepo.save(e);
		return "Added Successfully";
	}

	public Employee idNotAvailable(int id) throws EmployeeNotFoundException {
		
		return empRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException());
	}

	public Employee change(int id, Employee s) {
		Employee x=empRepo.findById(id).get();
		x.setName(s.getName());
		x.setAge(s.getAge());
		x.setGender(s.getGender());
		x.setId(s.getId());
		x.setSalary(s.getSalary());
		
		return empRepo.save(x);
	}

	public Employee modify(int id, Employee m) {
		Employee x=empRepo.findById(id).get();
		x.setSalary(m.getSalary());
		return empRepo.save(x);
	}

	
	

}
