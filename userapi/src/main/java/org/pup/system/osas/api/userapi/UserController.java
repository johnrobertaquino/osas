package org.pup.system.osas.api.userapi;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserManager userManager;

	@GetMapping("/users/checkFullName")
	public User checkFullName(@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, 
			@RequestParam("lastName") String lastName) throws Exception {
		User user = null;
		userManager = new UserManager();
		
		user = userManager.checkFullName(firstName, middleName, lastName);
		
		return user;
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
