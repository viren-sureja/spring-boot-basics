package io.javabrains.springbootquickstart.courseapi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // automatically converts to json data
public class TopicController {

    /*
     * Spring can autowire a relationship between collaborating beans without using
     * constructor-arg and property tags which helps with the amount of XML
     * configuration. Autowiring of the Spring framework enables you to inject the
     * object dependency implicitly.
     */
    @Autowired
    private TopicService topicService;

    /*
     * @RequestMapping is one of the most common annotation used in Spring Web
     * applications. This annotation maps HTTP requests to handler methods of MVC
     * and REST controllers.
     */
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    /*
     * use PathVariable to get value from the path eg. id which will be variable
     */
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void addTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void addTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
