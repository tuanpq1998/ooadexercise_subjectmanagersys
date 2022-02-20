package vn.edu.hust.ooad.subjectmanagersys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hust.ooad.subjectmanagersys.entity.Period;
import vn.edu.hust.ooad.subjectmanagersys.repository.PeriodRepository;

@Service
public class PeriodService {

	@Autowired
	private PeriodRepository periodRepository;
	
	public List<Period> getAll() {
		return periodRepository.findAll();
	}

	public void createNew(Period period) {
		period.setActive(true);
		periodRepository.save(period);
	}

	public Period findLastest() {
		Period p = periodRepository.findByRepresentIsTrue();
		return p;
	}
}
