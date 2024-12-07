package com.example.gemini;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class AiService {
    private final GeminiClient geminiClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    public String calculateShippingDeadline(GeminiRequest request) {
        GeminiResponse response = geminiClient.getCompletion(request, apiKey);
        log.info("GeminiResponse: {}", response);
        return extractDeadlineFromResponse(response);
    }

    private String extractDeadlineFromResponse(GeminiResponse response) {
        // 응답에서 최종 발송 시한 추출 로직 구현
        // 예: return response.getCandidates().get(0).getContent().getParts().get(0).getText();
        return response.getCandidates().get(0).getContent().getParts().get(0).getText();
    }
}
