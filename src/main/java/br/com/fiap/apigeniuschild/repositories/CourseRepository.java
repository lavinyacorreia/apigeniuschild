package br.com.fiap.apigeniuschild.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.apigeniuschild.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	
}
