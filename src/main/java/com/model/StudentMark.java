package com.model;


	

	import java.sql.Date;

	public class StudentMark {

	    private int studentID;
	    private String studentName;
	    private String subject;
	    private int marks;
	    private Date examDate;

	    // Getter and Setter for StudentID
	    public int getStudentID() {
	        return studentID;
	    }

	    public void setStudentID(int studentID) {
	        this.studentID = studentID;
	    }

	    // Getter and Setter for StudentName
	    public String getStudentName() {
	        return studentName;
	    }

	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }

	    // Getter and Setter for Subject
	    public String getSubject() {
	        return subject;
	    }

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

	    // Getter and Setter for Marks
	    public int getMarks() {
	        return marks;
	    }

	    public void setMarks(int marks) {
	        this.marks = marks;
	    }

	    // Getter and Setter for ExamDate
	    public Date getExamDate() {
	        return examDate;
	    }

	    public void setExamDate(Date examDate) {
	        this.examDate = examDate;
	    }
	}

