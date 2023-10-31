package demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.UserInfo;
import demo.obj.UserInfoObj;
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
	public UserInfo saveUserInfo(UserInfoObj userInfoObj) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userInfoObj.getUserId());
		userInfo.setUserName(userInfoObj.getUserName());
		userInfo.setSex(userInfoObj.getSex());
		userInfo.setBirth(userInfoObj.getBirth());
		userInfo.setPostCode(userInfoObj.getPostCode());
		userInfo.setTodoufuken(userInfoObj.getTodoufuken());
		userInfo.setShikucyouson(userInfoObj.getShikucyouson());
		userInfo.setCyoumebanchi(userInfoObj.getCyoumebanchi());
		userInfo.setRoomNumber(userInfoObj.getRoomNumber());
		userInfo.setPhoneNumber(userInfoObj.getPhoneNumber());

		return userInfoRepositroy.save(userInfo);
	}

	/**
	 * ユーザー情報を全件取得する
	 * @return userInfoObjList
	 */
	//	public List<UserInfo> findAllUserInfo() {
	//		return userInfoRepositroy.findAll();
	//	}

	public List<UserInfoObj> findAllUserInfo() {

		List<UserInfoObj> userInfoObjList = new ArrayList<UserInfoObj>();
		List<UserInfo> userInfoList = userInfoRepositroy.findAll();

		for (UserInfo u : userInfoList) {

			UserInfoObj obj = new UserInfoObj();
			obj.setUserId(u.getUserId());
			obj.setSex(u.getSex());
			obj.setBirth(u.getBirth());
			obj.setPostCode(u.getPostCode());
			obj.setTodoufuken(u.getTodoufuken());
			obj.setShikucyouson(u.getShikucyouson());
			obj.setCyoumebanchi(u.getCyoumebanchi());
			obj.setRoomNumber(u.getRoomNumber());
			obj.setPhoneNumber(u.getPhoneNumber());

			userInfoObjList.add(obj);
		}
		return userInfoObjList;
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
	 * @param userInfo
	 * @return userInfo
	 */
	public void deleteuserInfo(String userInfo) {
		userInfoRepositroy.deleteById(userInfo);
	}

}
