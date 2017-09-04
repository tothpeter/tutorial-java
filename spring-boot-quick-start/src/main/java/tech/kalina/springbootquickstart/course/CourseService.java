package tech.kalina.springbootquickstart.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		
		repository.findAll().forEach(list::add);

	    return list;
	}
	
	public List<Course> getAllCourses(int topicId) {
		List<Course> list = new ArrayList<>();
		
		repository.findByTopicId(topicId).forEach(list::add);

	    return list;
	}

	public Course get(int id) {
		return repository.findOne(id);
	}

	public void add(Course topic) {
		repository.save(topic);
	}
	
	public void update(int id, Course topic) {
		topic.setId(id);
		repository.save(topic);
	}
	
	public void delete(int id) {
		repository.delete(id);
	}
}
