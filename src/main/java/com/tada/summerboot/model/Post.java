package com.tada.summerboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;

    @Column(nullable = true) // allow null value in this column
    private String title;

    @Column(nullable = true, columnDefinition="mediumblob")
    private byte[] image;

    @Column(nullable = true, columnDefinition="TEXT") // allow null value in this column
    private String content;

    @Column(nullable = true) // allow null value in this column
    private String imageURL;

    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;

    @Column(nullable = true) // allow null value in this column
    private Timestamp timestamp;

    public Post(Integer id, String title, String content, Integer user_id, byte[] bytes, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.image = bytes;
        this.timestamp = timestamp;
    }

    public Post(){
        super();
    }

    public Post(Integer id, String title, String content, Integer user_id, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }
}