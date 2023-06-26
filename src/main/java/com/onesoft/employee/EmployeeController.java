package com.onesoft.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class EmployeeController {
	@Autowired
	EmployeeService empser;
	
	static Logger log=Logger.getLogger(EmployeeController.class);

	@PostMapping(value = "/postEmployee")
	public String addEmployee(@RequestBody Employee e) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(e);
		return empser.addEmployee(e);
	}

	@PostMapping(value = "/addEmpList")
	public String addAllEmployees(@RequestBody List<Employee> emps) {
		
		return empser.addAllEmployees(emps);
	}

	@GetMapping(value = "/employee/{ob}")
	public Employee findOneValue(@PathVariable int ob) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(ob);
		return empser.findOneValue(ob);
	}

	@GetMapping(value = "/emplo")
	public List<Employee> getList() {
		return empser.getList();
	}

	@DeleteMapping(value = "/deleteId/{d}")
	public String deleteValue(@PathVariable int d) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(d);
		return empser.deleteValue(d);
	}

	@PutMapping(value = "/putEmployee/{e}")
	public String putEmployee(@RequestBody Employee e) {
		return empser.putEmployee(e);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return empser.getByGender(gender);
	}

	@GetMapping(value = "/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) {
		return empser.getByName(name);
	}

	@GetMapping(value = "getBysalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empser.getBySalary(salary);
	}

	@GetMapping(value="/getBySalary/{sal1}/{sal2}")
	public List<Employee> getEmpBySalary(@PathVariable int sal1,@PathVariable int sal2) {
		return empser.getEmpBySalary(sal1,sal2);
	}
	
	@GetMapping(value="/getByNameEmpo/{name}")
	public List<Employee> getByControllerName(@PathVariable String name) {
		return empser.getByServiceName(name);
	}
	
	@GetMapping(value = "/getIncrement")
	public List<Employee> incrementGender() {
		return empser.incrementGender();
	}
	
	@PostMapping(value = "/postEmployeeAge")
	public String addExcepEmployee(@RequestBody Employee e) throws AgeNotFoundException{
		return empser.addExcepEmployee(e);
	}
	
	@GetMapping(value = "/idNotAvailable/{id}")
	public Employee idNotAvailable(@PathVariable int id) throws EmployeeNotFoundException {
		return empser.idNotAvailable(id);
	}
	
	@GetMapping(value = "/nameNotAvailable/{name}")
	public List<Employee>
	nameNotAvailable(@PathVariable String name) throws NameNotFoundException {
		return empser.nameNotAvailable(name);
	}
	
	RestTemplate rest=new RestTemplate();
	@GetMapping(value="/getCarsViaEmployee")
	public List<Car> getCarsViaEmployee() {
		String url="http://localhost:8080/car/carList";
		ResponseEntity<List<Car>> response=rest.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>() {});
		List<Car>cars=response.getBody();
		return cars;
		
	}
	
	@PutMapping(value="/updatevalue/{id}")
	public Employee change(@PathVariable int id, @RequestBody Employee s) {
		return empser.change(id,s);
	}
	
	@PatchMapping(value="/modifyvalue/{id}")
	public Employee modify(@PathVariable int id, @RequestBody Employee m) {
		return empser.modify(id,m);
	}
}
