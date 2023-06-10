package com.example.theplayer.dataprovider.feignClient;

import com.example.theplayer.domain.ChatRequest;
import com.example.theplayer.domain.ChatResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "ChatGptFeignClient",
        url = "https://api.openai.com/v1"
)
public interface ChatGptFeignClient {
    
    @PostMapping(value = "/chat/completions",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<ChatResponse> createConversation(@RequestBody ChatRequest message, @RequestHeader("Authorization") String apiKey);
    
}
