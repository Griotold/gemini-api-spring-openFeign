package com.example.gemini;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@NoArgsConstructor
@Getter
public class GeminiResponse {

    private List<Candidate> candidates;

    @ToString
    @Getter
    @Setter
    public static class Candidate {
        private Content content;
        private String finishReason;
        private int index;
        private List<SafetyRating> safetyRatings;

    }

    @ToString
    @Getter
    public static class Content {
        private List<TextPart> parts;
        private String role;
    }

    @ToString
    @Getter
    public static class TextPart {
        private String text;
    }

    @ToString
    @Getter
    public static class SafetyRating {
        private String category;
        private String probability;
    }
}
