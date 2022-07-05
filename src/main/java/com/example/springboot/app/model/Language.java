package com.example.springboot.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Languages")
public class Language {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name="code")
        private String code;

        @Column(name="name")
        private String name;

    @ManyToMany(mappedBy = "likedLanguages")
    private List<Employee> likes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getLikes() {
        return likes;
    }

    public void setLikes(List<Employee> likes) {
        this.likes = likes;
    }
}
