package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.UserLoginInfo;

@Repository
public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfo, String> {

	UserLoginInfo findByUserIdAndPassword(String userId, String password);

}