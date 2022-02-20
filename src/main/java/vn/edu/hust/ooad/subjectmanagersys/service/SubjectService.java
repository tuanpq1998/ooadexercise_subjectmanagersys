package vn.edu.hust.ooad.subjectmanagersys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hust.ooad.subjectmanagersys.entity.Subject;
import vn.edu.hust.ooad.subjectmanagersys.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}

	public void createNew(Subject subject) {
		subjectRepository.save(subject);
	}

	public Subject findBySerial(String subjectSerial) {
		return subjectRepository.findBySerial(subjectSerial);
	}

	public void saveEdit(Subject subject) {
		Subject old = findBySerial(subject.getSerial());
		if (old != null) {
			subject.setId(old.getId());
			subjectRepository.save(subject);
		}
	}
}
