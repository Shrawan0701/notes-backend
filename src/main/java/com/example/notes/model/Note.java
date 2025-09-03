package com.example.notes.model;

import java.util.UUID;

public class Note {
    private String id;
    private String content;
    private String slug; // optional public link

    public Note() {
        this.id = UUID.randomUUID().toString();
    }

    public Note(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
    }

    public String getId() { return id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
}
