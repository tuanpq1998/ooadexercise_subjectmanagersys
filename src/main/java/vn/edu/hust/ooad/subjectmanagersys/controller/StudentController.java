package vn.edu.hust.ooad.subjectmanagersys.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hust.ooad.subjectmanagersys.entity.Period;
import vn.edu.hust.ooad.subjectmanagersys.entity.Subject;
import vn.edu.hust.ooad.subjectmanagersys.entity.User;
import vn.edu.hust.ooad.subjectmanagersys.entity.UserSubject;
import vn.edu.hust.ooad.subjectmanagersys.service.PeriodService;
import vn.edu.hust.ooad.subjectmanagersys.service.SubjectService;
import vn.edu.hust.ooad.subjectmanagersys.service.UserService;
import vn.edu.hust.ooad.subjectmanagersys.service.UserSubjectService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSubjectService userSubjectService;
	
	@Autowired
	private PeriodService periodService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping({"/",""})
	public String showIndexPage(Model model, Principal principal) {
		String username = principal.getName();
		List<UserSubject> userSubjects = userSubjectService.findByUsername(username);
		model.addAttribute("userSubjects", userSubjects);
		model.addAttribute("newPeriod", periodService.findLastest());
		
		return "student/index";
	}
	
	@GetMapping("/new")
	public String showRequestForm(Model model, Principal principal) {
		Period lastestPeriod = periodService.findLastest();
		model.addAttribute("newPeriod", lastestPeriod);
		model.addAttribute("userSubject", new UserSubject());
		
		model.addAttribute("isAllowToCreate", userSubjectService.isAllowToCreate(principal.getName(), lastestPeriod));
		
		return "student/createrequest";
	}
	
	@PostMapping("/new")
	public String handleCreateNewRequest(@ModelAttribute UserSubject userSubject, Principal principal) {
		userSubject.setPeriod( periodService.findLastest());
		
		User user = userService.findByUsername(principal.getName());
		userSubject.setUser(user);
		
		Subject subject = subjectService.findBySerial(userSubject.getSubject().getSerial());
		userSubject.setSubject(subject);
		
		userSubjectService.save(userSubject);
		
		return "redirect:/student";
	}
	
	@GetMapping("/edit")
	public String showRequestEditForm(@RequestParam("id") int userSubjectId, Model model) {
		model.addAttribute("userSubject", userSubjectService.findById(userSubjectId));
		
		return "student/editrequest";
	}
	
	@PostMapping("/edit")
	public String handleRequestEdit(@ModelAttribute UserSubject userSubject) {
		userSubjectService.updateByStudent(userSubject);
		
		return "redirect:/student";
	}
	
	@GetMapping("/profile")
	public String showUserProfile(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", userService.findByUsername(username) );
		return "student/profile";
	}
	
	@PostMapping("/profile")
	public String handleChangeInfo(@ModelAttribute User user, Principal principal) {
		user.setUsername(principal.getName());
		userService.update(user);
		return "redirect:/student";
	}
}
