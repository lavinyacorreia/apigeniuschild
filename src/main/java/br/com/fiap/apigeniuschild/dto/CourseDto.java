package br.com.fiap.apigeniuschild.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CourseDto {
	
	@NotBlank
	private String courseName;
	@NotBlank
	private String courseDescription;
	@NotNull
	private Double coursePrice;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
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
}
