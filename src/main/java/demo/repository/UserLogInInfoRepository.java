package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.UserLogInInfo;

@Repository
public interface UserLogInInfoRepository extends JpaRepository<UserLogInInfo, String> {

	UserLogInInfo findByUserIdAndPassword(String userId, String password);

}