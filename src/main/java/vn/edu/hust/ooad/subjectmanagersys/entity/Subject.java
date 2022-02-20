package vn.edu.hust.ooad.subjectmanagersys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="serial")
	private String serial;
	
	@Column(name="is_require_attach_class")
	boolean requireAttachClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public boolean isRequireAttachClass() {
		return requireAttachClass;
	}

	public void setRequireAttachClass(boolean isRequireAttachClass) {
		this.requireAttachClass = isRequireAttachClass;
	}

	public Subject(int id, String name, String serial, boolean isRequireAttachClass) {
		super();
		this.id = id;
		this.name = name;
		this.serial = serial;
		this.requireAttachClass = isRequireAttachClass;
	}

	public Subject() {
		super();
	}
	
	
	
}
