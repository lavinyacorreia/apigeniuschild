package br.com.fiap.apigeniuschild.controller;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.apigeniuschild.dto.CourseDto;
import br.com.fiap.apigeniuschild.entities.Course;
import br.com.fiap.apigeniuschild.service.CourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
 
	@Autowired
	private CourseService courseService;
	
	@PostMapping
    public ResponseEntity<Object> saveCourse(@RequestBody @Valid CourseDto courseDto){
        var courseModel = new Course();
        System.out.println(courseDto.getCoursePrice());
        BeanUtils.copyProperties(courseDto, courseModel);
        System.out.println(courseModel.getCoursePrice());
        courseModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseModel));
    }
	
	@GetMapping
    public ResponseEntity<Page<Course>> getCourse(@PageableDefault(page = 0, size = 10, sort = "courseId", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll(pageable));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> getOneCourse(@PathVariable(value = "id") Long id){
        Optional<Course> courseModelOptional = courseService.findById(id);
        if (!courseModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(courseModelOptional.get());
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "id") Long id){
        Optional<Course> courseModelOptional = courseService.findById(id);
        if (!courseModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
        courseService.delete(courseModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully.");
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid CourseDto courseDto){
        Optional<Course> courseModelOptional = courseService.findById(id);
        if (!courseModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
        }
        var CourseModel = new Course();
        BeanUtils.copyProperties(courseDto, CourseModel);
        CourseModel.setCourseId(courseModelOptional.get().getCourseId());
        CourseModel.setRegistrationDate(courseModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(courseService.save(CourseModel));
    }
}
