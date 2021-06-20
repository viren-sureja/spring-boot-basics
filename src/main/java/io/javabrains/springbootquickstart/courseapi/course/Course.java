package io.javabrains.springbootquickstart.courseapi.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.springbootquickstart.courseapi.topic.Topic;

// by this annotations JPA will create table called topic which will have 3 col. des. id and name.
@Entity
public class Course {
    private String description;
    /* this annotation tells that id is the primary key */
    @Id
    private String id;
    private String name;

    @ManyToOne // as there are many course in topic
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.topic = new Topic(topicId, "", "");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
