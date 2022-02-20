package vn.edu.hust.ooad.subjectmanagersys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hust.ooad.subjectmanagersys.entity.Period;
import vn.edu.hust.ooad.subjectmanagersys.entity.Subject;
import vn.edu.hust.ooad.subjectmanagersys.entity.UserSubject;
import vn.edu.hust.ooad.subjectmanagersys.repository.UserSubjectRepository;

@Service
public class UserSubjectService {

	@Autowired
	private UserSubjectRepository userSubjectRepository;
	
	@Autowired
	private SubjectService subjectService; 

	public List<UserSubject> findAllByPeriodName(String periodName) {
		List<UserSubject> userSubjects = userSubjectRepository.findAllByPeriod_Name(periodName);
		return userSubjects;
	}

	public UserSubject findById(int userSubjectId) {
		Optional<UserSubject> res = userSubjectRepository.findById(userSubjectId);
		UserSubject userSubject = null;
		if (res.isPresent())
			userSubject = res.get();
		return userSubject;
	}

	public void updateByStaff(UserSubject userSubject) {
		UserSubject old = findById(userSubject.getId());
		
		userSubject.setUser(old.getUser());
		userSubject.setSubject(old.getSubject());
		userSubject.setClassId(old.getClassId());
		userSubject.setAttachClassId(old.getAttachClassId());
		userSubject.setPeriod(old.getPeriod());
		
		userSubjectRepository.save(userSubject);
	}

	public List<UserSubject> findByUsername(String username) {
		return userSubjectRepository.findAllByUser_Username(username);
	}

	public void save(UserSubject userSubject) {
		userSubjectRepository.save(userSubject);
	}

	public boolean isAllowToCreate(String username, Period lastestPeriod) {
		int countUserSubjectByUsername = 
				userSubjectRepository.countByUser_UsernameIsAndPeriod_NameIs(username, lastestPeriod.getName());
		int max = lastestPeriod.getMaxAllow();
		return countUserSubjectByUsername < max;
	}

	public void updateByStudent(UserSubject userSubject) {
		UserSubject old = findById(userSubject.getId());
		
		old.setClassId(userSubject.getClassId());
		old.setAttachClassId(userSubject.getAttachClassId());
		
		Subject s = subjectService.findBySerial(userSubject.getSubject().getSerial());
		old.setSubject(s);
		
		userSubjectRepository.save(old);
	}
	
}
