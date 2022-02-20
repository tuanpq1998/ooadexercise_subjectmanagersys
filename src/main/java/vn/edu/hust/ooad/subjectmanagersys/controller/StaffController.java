package vn.edu.hust.ooad.subjectmanagersys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hust.ooad.subjectmanagersys.entity.Period;
import vn.edu.hust.ooad.subjectmanagersys.entity.Subject;
import vn.edu.hust.ooad.subjectmanagersys.entity.UserSubject;
import vn.edu.hust.ooad.subjectmanagersys.service.PeriodService;
import vn.edu.hust.ooad.subjectmanagersys.service.SubjectService;
import vn.edu.hust.ooad.subjectmanagersys.service.UserSubjectService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private PeriodService periodService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private UserSubjectService userSubjectService;
	
	@GetMapping({"", "/"})
	public String showIndexPage() {
		return showWayToLastestPeriodRequest();
	}
	
	@GetMapping({"period", "period/"})
	public String showAllPeriod(Model model) {
		List<Period> periods = periodService.getAll();
		model.addAttribute("periods", periods);
		return "staff/period/index";
	}
	
	@GetMapping({"period/new"})
	public String showPeriodForm(Model model) {
		model.addAttribute("period", new Period());
		return "staff/period/create";
	}
	
	@PostMapping("period/new")
	public String handleCreatePeriod(@ModelAttribute Period newPeriod) {
		periodService.createNew(newPeriod);
		return "redirect:/staff/period";
	}
	
	@GetMapping({"subject", "subject/"})
	public String showAllSubject(Model model) {
		List<Subject> subjects = subjectService.getAll();
		model.addAttribute("subjects", subjects);
		return "staff/subject/index";
	}
	
	@GetMapping("subject/new")
	public String showSubjectForm(Model model) {
		model.addAttribute("subject", new Subject());
		return "staff/subject/create";
	}
	
	@PostMapping("subject/new")
	public String handleCreateSubject(@ModelAttribute Subject subject) {
		subjectService.createNew(subject);
		return "redirect:/staff/subject";
	}
	
	@GetMapping("subject/edit/{subjectSerial}")
	public String showSubjectEditForm(@PathVariable String subjectSerial, Model model) {
		Subject subject = subjectService.findBySerial(subjectSerial);
		model.addAttribute("subject", subject);
		return "staff/subject/create";
	}
	
	@PostMapping("subject/edit/{subjectSerial}")
	public String handleEditSubject(@ModelAttribute Subject subject, @PathVariable String subjectSerial) {
		subject.setSerial(subjectSerial);
		subjectService.saveEdit(subject);
		return "redirect:/staff/subject";
	}
	
	@GetMapping("request")
	public String showWayToLastestPeriodRequest() {
		Period p = periodService.findLastest();
		return "redirect:/staff/request/" + p.getName();
	}
	
	@GetMapping("request/{periodName}")
	public String showPeriodDetail(@PathVariable String periodName, Model model) {
		List<UserSubject> requests = userSubjectService.findAllByPeriodName(periodName);
		model.addAttribute("userSubjects", requests);
		model.addAttribute("periodName", periodName);
		return "staff/request/index";
	}
	
	@GetMapping("request/")
	public String showUserSubjectDetail(@RequestParam("id") int userSubjectId, Model model) {
		UserSubject userSubject = userSubjectService.findById(userSubjectId);
		model.addAttribute("userSubject", userSubject);
		return "staff/request/detail";
	}
	
	@PostMapping("request/")
	public String handleEditRequest(@RequestParam("id") int userSubjectId, 
			@ModelAttribute UserSubject userSubject) {
		userSubject.setId(userSubjectId);
		userSubjectService.updateByStaff(userSubject);
		return "redirect:/staff/request";
	}
}
