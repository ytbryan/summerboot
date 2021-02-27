package com.tada.summerboot.model;

<<<<<<< Updated upstream
import javax.persistence.*;

=======

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Setter
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
=======
    @Column(nullable = true, columnDefinition="mediumblob")
    private byte[] image;
>>>>>>> Stashed changes



    public Post(Integer id, String title, String content, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }

    public Post(String title, String content, String imageURL) {
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }

    public Post(){
        super();
    }

<<<<<<< Updated upstream
=======
    public Post(String title, String content, Integer user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public Post(String title, String content, Integer user_id, byte[] image) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.image = image;
    }

    public Post(String title, String content, Integer user_id, String imageURL) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }

    public Post(Integer id, String title, String content, Integer user_id, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }

>>>>>>> Stashed changes
}
