package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	
	
	
	@GetMapping("/homePage")
	public String normalUserInfo(Model model) {

		model.addAttribute("homePage", "normalUserInfo");

		return "homePage";
	}
}