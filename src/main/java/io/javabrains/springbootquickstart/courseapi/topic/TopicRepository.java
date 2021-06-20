package io.javabrains.springbootquickstart.courseapi.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
    // entity is the string while id is the string
}
