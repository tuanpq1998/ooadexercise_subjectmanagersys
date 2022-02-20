package vn.edu.hust.ooad.subjectmanagersys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private int id;
	
	@Column
	private String username, email, phone;
	
	@Column(name="class")
	private String className;
	
	@Column
	private String fullname;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column
	private String password;
	
	@Column(name="is_staff")
	private boolean staff;

	public User(int id, String username, String password, boolean isStaff) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.staff = isStaff;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStaff() {
		return staff;
	}

	public void setStaff(boolean isStaff) {
		this.staff = isStaff;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", isStaff=" + staff + "]";
	}

	
	
	
}
