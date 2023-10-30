package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.UserLogInInfo;
import demo.repository.UserLogInRepository;
import jakarta.servlet.http.HttpSession;

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

	//	@Autowired
	//	private UserInfoService userInfoService;
	//
	//	@GetMapping("/myPage")
	//	public String myPage(@RequestParam(name = "searchId", required = false) String searchId, Model model) {
	//
	//		Optional<UserInfo> userInfo = null;
	//		if (searchId != null) {
	//			
	//			userInfo = userInfoService.findUserInfoById(searchId);
	//
	//		}
	//
	//		model.addAttribute("userInfo", userInfo);
	//		
	//		return "myPage";
	//	}

	@Autowired
	private UserLogInRepository userLogInRepository;

	@PostMapping("/loginPage")
	public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {
		UserLogInInfo userLogInInfo = userLogInRepository.findByUserIdAndPassword(userId, password);

		if (userLogInInfo != null) {
			session.setAttribute("loggedInUser", userLogInInfo);
			return "redirect:/myPage";
		} else {
			return "loginPage";
		}
	}

}
