package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String author;
    private String name;
    private String category;
    private MultipartFile file;

    public SongForm() {
    }

    public SongForm(String author, String name, String category, MultipartFile file) {
        this.author = author;
        this.name = name;
        this.category = category;
        this.file = file;
    }

    public SongForm(int id, String author, String name, String category, MultipartFile file) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.category = category;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}