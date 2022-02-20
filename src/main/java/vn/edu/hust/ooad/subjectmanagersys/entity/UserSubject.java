package vn.edu.hust.ooad.subjectmanagersys.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import vn.edu.hust.ooad.subjectmanagersys.utility.DateTimeHandler;


@Entity
@Table(name="user_subject")
public class UserSubject {

	@Id
	private int id;
	
	@Column
	private String attachClassId;
	
	@Column
	private String classId;
	
	@Column
	private String replyMessage;
	
	@Column
	private boolean isComplete;
	
	@Column(updatable = false)
	private String createAt;
	
	@Column
	private String updateAt;
	
	public String getClassId() {
		return classId;
	}

	@Override
	public String toString() {
		return "UserSubject [id=" + id + ", attachClassId=" + attachClassId + ", classId=" + classId + ", replyMessage="
				+ replyMessage + ", isComplete=" + isComplete + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ "]";
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="period_id")
	private Period period;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="subject_id")
	private Subject subject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttachClassId() {
		return attachClassId;
	}

	public void setAttachClassId(String attachClassId) {
		this.attachClassId = attachClassId;
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public UserSubject(int id, String attachClassId, String replyMessage, boolean isComplete) {
		super();
		this.id = id;
		this.attachClassId = attachClassId;
		this.replyMessage = replyMessage;
		this.isComplete = isComplete;
	}

	public UserSubject() {
		super();
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist
	public void onCreate() {
		createAt = DateTimeHandler.datetimeToString(new Date());
	}
	
	@PreUpdate
	public void onUpdate() {
		updateAt = DateTimeHandler.datetimeToString(new Date());
	}
}
