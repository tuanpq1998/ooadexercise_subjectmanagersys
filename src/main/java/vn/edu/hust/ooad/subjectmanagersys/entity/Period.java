package vn.edu.hust.ooad.subjectmanagersys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="period")
public class Period {

	@Id
	private int id;
	
	@Column
	private int maxAllow;
	
	public int getMaxAllow() {
		return maxAllow;
	}

	public void setMaxAllow(int maxAllow) {
		this.maxAllow = maxAllow;
	}

	@Column
	private String name;
	
	@Column
	private String startTime;
	
	@Column
	private String endTime;
	
	@Column(name="is_active")
	private boolean active;
	
	@Column(name="is_represent")
	private boolean represent;

	public Period(int id, String name, String startTime, String endTime, boolean isActive, boolean isRepresent) {
		super();
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.active = isActive;
		this.represent = isRepresent;
	}

	public Period() {
		super();
	}

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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public boolean isRepresent() {
		return represent;
	}

	public void setRepresent(boolean isRepresent) {
		this.represent = isRepresent;
	}
	
	
}
