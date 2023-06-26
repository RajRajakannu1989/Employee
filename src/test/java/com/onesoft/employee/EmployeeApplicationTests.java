package com.onesoft.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	EmployeeController empContro;
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testFindOneValue() {
		empContro.findOneValue(8);
	}

}
