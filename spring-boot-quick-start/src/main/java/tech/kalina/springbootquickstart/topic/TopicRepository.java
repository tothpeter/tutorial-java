package tech.kalina.springbootquickstart.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tech.kalina.springbootquickstart.course.Course;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
