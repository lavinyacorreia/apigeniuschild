package br.com.fiap.apigeniuschild.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "course_description")
	private String courseDescription;
	@Column(name = "course_price")
	private Double coursePrice;
	@Column(name = "registration_date")
	private LocalDateTime registrationDate;
	
	public Course() {
	}
	
	public Course(Long courseId, String courseName, String courseDescription, Double coursePrice) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
	}

	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getcourseName() {
		return courseName;
	}
	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Double coursePrice) {
		this.coursePrice = coursePrice;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
