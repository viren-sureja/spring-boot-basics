package io.javabrains.springbootquickstart.courseapi.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
    // entity is the string while id is the string

    public List<Course> findByTopicId(String topicId);
}
