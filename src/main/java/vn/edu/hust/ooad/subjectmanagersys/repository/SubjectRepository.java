package vn.edu.hust.ooad.subjectmanagersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.hust.ooad.subjectmanagersys.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	Subject findBySerial(String subjectSerial);

}
