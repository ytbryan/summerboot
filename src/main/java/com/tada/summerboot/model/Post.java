package com.tada.summerboot.model;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;
    private String title;
    private String content;
    private String imageURL;

    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;

    @Column(nullable = true, columnDefinition="mediumblob")
    private byte[] image;

    public Post(String title, String content, Integer user_id, byte[] image) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.image = image;
    }


    public Post(Integer id, String title, String content, Integer user_id, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }
    public Post(){
        super();
    }
}
