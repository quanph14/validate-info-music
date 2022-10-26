package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String author;
    private String name;
    private String category;
    private String filePath;

    public Song(long id, String author, String name, String category, String filePath) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.category = category;
        this.filePath = filePath;
    }

    public Song(String author, String name, String category, String filePath) {
        this.author = author;
        this.name = name;
        this.category = category;
        this.filePath = filePath;
    }

    public Song() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}