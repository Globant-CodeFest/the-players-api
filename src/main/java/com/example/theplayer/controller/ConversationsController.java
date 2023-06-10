package com.example.theplayer.controller;

import com.example.theplayer.dataprovider.usecase.CreateConversation;
import com.example.theplayer.domain.ConversationRequest;
import com.example.theplayer.domain.ConversationResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationsController {
    
    private final CreateConversation createConversation;

    @Autowired
    public ConversationsController(CreateConversation createConversation) {
        this.createConversation = createConversation;
    }
    
    @GetMapping("/ping") 
    public String ping() {
        return "Pong";
    }
    
    @PostMapping("/conversations")
    public ResponseEntity<ConversationResponse> createConversation(@RequestBody ConversationRequest conversationRequest) {
        return ResponseEntity.of(createConversation.createConversation(conversationRequest));
    }
    
}
