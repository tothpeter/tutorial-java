package tech.kalina.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> list = new ArrayList<>();
		
		topicRepository.findAll().forEach(list::add);

	    return list;
	}

	public Topic getTopic(int id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(int id, Topic topic) {
		topic.setId(id);
		topicRepository.save(topic);
	}
	
	public void deleteTopic(int id) {
		topicRepository.delete(id);
	}
}
