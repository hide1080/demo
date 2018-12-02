package com.example.demo;

import java.util.Objects;

public class Greeting {
    private final long id;
    private final String content;

    static Greeting of(long id, String content) {
        Objects.requireNonNull(content);
        return new Greeting(id, content);
    }

    private Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
