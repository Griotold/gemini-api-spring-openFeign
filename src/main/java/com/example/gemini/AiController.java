package com.example.gemini;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping("/gemini")
    public ResponseEntity<String> getGeminiResponse(@RequestBody RequestDto request) {
        log.info("RequestDto: {}", request);
        GeminiRequest geminiRequest = new GeminiRequest(
                request.query(), request.start(), request.destination(), request.deadline()
        );
        log.info("GeminiRequest: {}", geminiRequest);
        String response = aiService.calculateShippingDeadline(geminiRequest);
        log.info("GeminiResponse: {}", response);
        return ResponseEntity.ok(response);
        // 응답 처리
    }
}
