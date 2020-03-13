package hr.mhercog.usermanagementservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.mhercog.usermanagementservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	@Query("select u.name from User u where u.id in (:pIdList)")
	List<String> findByIdList(@Param("pIdList") List<Long> idList);
}
