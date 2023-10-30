package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.UserInfo;
import demo.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepositroy;

	@Autowired
	public UserInfoService(UserInfoRepository userInfoRepositroy) {
		this.userInfoRepositroy = userInfoRepositroy;
	}

	/**
	 * ユーザー情報を更新する
	 * @param userInfo
	 * @return userInfo
	 */
	public UserInfo saveUserInfo(UserInfo userInfo) {
		return userInfoRepositroy.save(userInfo);
	}

	/**
	 * ユーザー情報を全件取得する
	 * @return userInfoリスト
	 */
	public List<UserInfo> findAllUserInfo() {
		return userInfoRepositroy.findAll();
	}

	/**
	 * 指定したidのユーザー情報を取得する
	 * @param id
	 * @return userInfo
	 */
	public Optional<UserInfo> findUserInfoById(String userInfo) {
		return userInfoRepositroy.findById(userInfo);
	}

	/**
	 * ユーザー情報を削除する
	 * @param productInfo
	 * @return productInfo
	 */
	public void deleteProductInfo(String userInfo) {
		userInfoRepositroy.deleteById(userInfo);
	}

}
