package demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.UserLoginInfo;
import demo.obj.UserLoginInfoObj;
import demo.repository.UserLoginInfoRepository;


@Service
public class UserLoginInfoService {

	@Autowired
	UserLoginInfoRepository userLoginfoInfoRepositroy;

	/**
	 * ユーザー情報を更新する
	 * @param userLoginInfo
	 * @return userLoginInfo
	 */
	public void saveUserLoginfoInfo(UserLoginInfoObj userLoginInfoObj) {

		LocalDateTime currentTime = LocalDateTime.now();

		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUserId(userLoginInfoObj.getUserId());
		userLoginInfo.setPassword(userLoginInfoObj.getPassword());
		userLoginInfo.setCreateDate(currentTime);
		userLoginInfo.setUpdateDate(currentTime);

		userLoginfoInfoRepositroy.save(userLoginInfo);
	}

}
