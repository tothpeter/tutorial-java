package tech.kalina.springbootquickstart.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> index() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> listCoursesOfATopic(@PathVariable int id) {
		return courseService.getAllCourses(id);
	}
	
	
	@RequestMapping("/courses/{id}")
	public Course show(@PathVariable int id) {
		return courseService.get(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public Course create(@RequestBody Course course) {
		courseService.add(course);
		return course;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
	public Course update(@RequestBody Course topic, @PathVariable int id) {
		courseService.update(id, topic);
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
	public void destroy(@PathVariable int id) {
		courseService.delete(id);
	}
}
