package demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	Optional<UserInfo> findById(String userInfo);

	void deleteById(String userInfo);

}
