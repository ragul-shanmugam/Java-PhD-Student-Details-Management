package com.ragul.db1.webinterface;

public class StudentDetails {
	private String StudentId;
	private String insFirstName;
	private String insLastName;
	private String StudentType;
	private String cname;
	private String passedate;
	private String stuFirstName;
	private String stuLastName;

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public String getInsFirstName() {
		return insFirstName;
	}

	public void setInsFirstName(String insFirstName) {
		this.insFirstName = insFirstName;
	}

	public String getInsLastName() {
		return insLastName;
	}

	public void setInsLastName(String insLastName) {
		this.insLastName = insLastName;
	}

	public String getStudentType() {
		return StudentType;
	}

	public void setStudentType(String studentType) {
		StudentType = studentType;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassdate() {
		return passedate;
	}

	public void setPassdate(String passdate) {
		this.passedate = passdate;
	}

	public String getStuFirstName() {
		return stuFirstName;
	}

	public void setStuFirstName(String stuFirstName) {
		this.stuFirstName = stuFirstName;
	}

	public String getStuLastName() {
		return stuLastName;
	}

	public void setStuLastName(String stuLastName) {
		this.stuLastName = stuLastName;
	}
}
