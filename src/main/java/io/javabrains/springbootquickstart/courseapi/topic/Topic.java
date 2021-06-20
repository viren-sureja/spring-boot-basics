package io.javabrains.springbootquickstart.courseapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

// by this annotations JPA will create table called topic which will have 3 col. des. id and name.
@Entity
public class Topic {
    private String description;
    /* this annotation tells that id is the primary key */
    @Id
    private String id;
    private String name;

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        this.description = description;
        this.id = id;
        this.name = name;
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

}
