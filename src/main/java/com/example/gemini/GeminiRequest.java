package com.example.gemini;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class GeminiRequest {
    private List<Content> contents;

    public GeminiRequest(String query, String start, String destination, String deadline) {
        this.contents = new ArrayList<>();
        Content content = new Content();
        Part part = new Part();
        part.setText(String.format("%s 시작: %s, 목적지: %s, 마감시간: %s",
                query, start, destination, deadline));
        content.setParts(Collections.singletonList(part));
        this.contents.add(content);
    }

    // Getter
    public List<Content> getContents() {
        return contents;
    }

    @ToString
    public static class Content {
        private List<Part> parts;

        // Getter and Setter
        public List<Part> getParts() {
            return parts;
        }

        public void setParts(List<Part> parts) {
            this.parts = parts;
        }
    }

    @ToString
    public static class Part {
        private String text;

        // Getter and Setter
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
