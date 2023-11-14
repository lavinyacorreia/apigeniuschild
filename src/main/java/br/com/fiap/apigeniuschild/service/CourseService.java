package br.com.fiap.apigeniuschild.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.apigeniuschild.entities.Course;
import br.com.fiap.apigeniuschild.repositories.CourseRepository;
import jakarta.transaction.Transactional;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Transactional
	public Course save(Course courseModel) {
		return courseRepository.save(courseModel);
	}
	
	public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }
	
	public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
	
	@Transactional
    public void delete(Course courseModel) {
        courseRepository.delete(courseModel);
    }
	
}
