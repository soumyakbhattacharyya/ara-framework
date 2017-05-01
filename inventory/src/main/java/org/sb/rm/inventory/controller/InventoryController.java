package org.sb.rm.inventory.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class InventoryController {

	// http://stackoverflow.com/questions/2606572/junit-splitting-integration-test-and-unit-tests
	// https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
	// https://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-adding-validation-to-a-rest-api/
	// https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration#appcontext-config

	@RequestMapping("/")
	public String index() {
		return "TODO_IMPLEMENTATION";
	}
	
}
