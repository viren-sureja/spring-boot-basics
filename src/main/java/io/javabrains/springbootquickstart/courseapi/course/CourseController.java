package io.javabrains.springbootquickstart.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.courseapi.topic.Topic;

@RestController // automatically converts to json data
public class CourseController {

    /*
     * Spring can autowire a relationship between collaborating beans without using
     * constructor-arg and property tags which helps with the amount of XML
     * configuration. Autowiring of the Spring framework enables you to inject the
     * object dependency implicitly.
     */
    @Autowired
    private CourseService courseService;

    /*
     * @RequestMapping is one of the most common annotation used in Spring Web
     * applications. This annotation maps HTTP requests to handler methods of MVC
     * and REST controllers.
     */
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    /*
     * use PathVariable to get value from the path eg. id which will be variable
     */
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
