package vn.edu.hust.ooad.subjectmanagersys.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String showHomePage(Principal principal) {
		if (principal != null) System.out.println(principal.getName());
		return "index";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
