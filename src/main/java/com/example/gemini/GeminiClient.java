package com.example.gemini;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "geminiApi", url = "${gemini.api.url}")
public interface GeminiClient {
    @PostMapping("/models/gemini-pro:generateContent")
    GeminiResponse getCompletion(
            @RequestBody GeminiRequest request,
            @RequestHeader("x-goog-api-key") String apiKey
    );
}
