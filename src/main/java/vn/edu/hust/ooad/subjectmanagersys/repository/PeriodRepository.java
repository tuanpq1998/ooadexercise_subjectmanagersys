package vn.edu.hust.ooad.subjectmanagersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.hust.ooad.subjectmanagersys.entity.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {

	Period findByRepresentIsTrue();

}
