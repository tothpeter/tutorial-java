package tech.kalina.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "Topic1", "topic 1 desc"),
			new Topic(2, "Topic2", "topic 2 desc")
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(int id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic currentTopic = topics.get(i);
			
			if (currentTopic.getId() == id) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(int id) {
		topics.removeIf(t -> t.getId() == id);
	}
}
