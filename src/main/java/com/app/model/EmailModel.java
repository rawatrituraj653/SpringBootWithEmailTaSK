package com.app.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class EmailModel {
	@Email(message="Email ends With @gmail.com")
	private String userTo;
	@NotBlank(message="reqiured*******")
	@Size(min = 3 ,max = 30,message = "size should be 3 to 30 characters")
	private String subject;
	private String userCc;
	private String userBcc;
	@NotBlank(message = "required***")
	private String message;
	public EmailModel(String userTo, String subject, String userCc, String userBcc, String message) {
		super();
		this.userTo = userTo;
		this.subject = subject;
		this.userCc = userCc;
		this.userBcc = userBcc;
		this.message = message;
	}
	public EmailModel() {
		super();
	}
	public String getUserTo() {
		return userTo;
	}
	public void setUserTo(String userTo) {
		this.userTo = userTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUserCc() {
		return userCc;
	}
	public void setUserCc(String userCc) {
		this.userCc = userCc;
	}
	public String getUserBcc() {
		return userBcc;
	}
	public void setUserBcc(String userBcc) {
		this.userBcc = userBcc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "EmailModel [userTo=" + userTo + ", subject=" + subject + ", userCc=" + userCc + ", userBcc=" + userBcc
				+ ", message=" + message + "]";
	}
	
	
	
	
}
