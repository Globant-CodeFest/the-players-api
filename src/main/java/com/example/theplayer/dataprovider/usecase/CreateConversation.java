package com.example.theplayer.dataprovider.usecase;

import com.example.theplayer.domain.ConversationRequest;
import com.example.theplayer.domain.ConversationResponse;

import java.util.Optional;

public interface CreateConversation {
    
    Optional<ConversationResponse> createConversation(ConversationRequest conversationRequest);
    
}
