package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

	@GetMapping("/logInPage")
	public String logIn(Model model) {

		model.addAttribute("logInPage", "logInPage");

		return "logInPage";
	}
	
	@GetMapping("/userRegisterPage")
	public String register(Model model) {

		model.addAttribute("userRegisterPage", "userRegisterPage");

		return "userRegisterPage";
	}


}
