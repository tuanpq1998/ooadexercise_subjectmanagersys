package vn.edu.hust.ooad.subjectmanagersys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.hust.ooad.subjectmanagersys.entity.UserSubject;

@Repository
public interface UserSubjectRepository extends JpaRepository<UserSubject, Integer> {

	List<UserSubject> findAllByPeriod_Name(String periodName);

	List<UserSubject> findAllByUser_Username(String username);

	int countByUser_UsernameIsAndPeriod_NameIs(String username, String name);

}
