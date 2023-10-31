package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.model.UserLogInInfo;
import demo.obj.UserInfoObj;
import demo.repository.UserInfoRepository;
import demo.repository.UserLogInInfoRepository;
import demo.service.UserInfoService;

@Controller
public class AccountController {

	/**
	 * ユーザー登録画面を表示
	 * @param logInPage
	 * @return
	 */
	@GetMapping("/logInPage")
	public String logIn(Model model) {

		model.addAttribute("logInPage", "logInPage");

		return "logInPage";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param logInPage
	 * @return
	 */
	@GetMapping("/userRegisterPage")
	public String userRegister(Model model) {

		model.addAttribute("userRegisterPage", "userRegisterPage");

		return "userRegisterPage";
	}

	/**
	 * ユーザー新規登録処理
	 * @param myPage
	 * @return
	 */
	@Autowired
	private UserLogInInfoRepository userLogInInfoRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/userRegisterPage")
	public String userRegister(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		//		System.out.print(666);

		String Name = firstName + " " + lastName;

		UserInfoObj userInfoObj = new UserInfoObj();
		userInfoObj.setUserId(userId);
		userInfoObj.setUserName(Name);

		userInfoService.saveUserInfo(userInfoObj);

		UserLogInInfo userLoginInfo = new UserLogInInfo();
		userLoginInfo.setUserId(userId);
		userLoginInfo.setPassword(password);

		userLogInInfoRepository.save(userLoginInfo);

		return "myPage";
	}

}
