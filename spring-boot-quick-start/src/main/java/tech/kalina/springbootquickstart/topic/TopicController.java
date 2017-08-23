package tech.kalina.springbootquickstart.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> index() {
		return topicService.getAllTopics();
	}
	
	
	@RequestMapping("/topics/{id}")
	public Topic show(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public Topic create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public Topic update(@RequestBody Topic topic, @PathVariable int id) {
		topicService.updateTopic(id, topic);
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void destroy(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
}
