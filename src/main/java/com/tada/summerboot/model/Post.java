//package com.tada.summerboot.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.math.BigDecimal;
//
//@Entity
//public class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
//    private Integer id;
//    private String title;
//    private String content;
//    private String imageURL;
//
//    public Post(Integer id, String title, String content, String imageURL) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.imageURL = imageURL;
//    }
//
//    public Post(){
//        super();
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getImageURL() {
//        return imageURL;
//    }
//
//    public void setImageURL(String imageURL) {
//        this.imageURL = imageURL;
//    }
//
//}
