package com.example.theplayer.dataprovider.usecase;

import com.example.theplayer.dataprovider.feignClient.ChatGptFeignClient;
import com.example.theplayer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CreateConversationUseCaseImpl implements CreateConversation {
    
    private final String apiKey;
    private final ChatGptFeignClient client;
    private final String messagePrefix; 

    @Autowired
    public CreateConversationUseCaseImpl(@Value("${api-key}") String apiKey, ChatGptFeignClient client, @Value("${message-prefix}") String messagePrefix) {
        this.apiKey = apiKey;
        this.client = client;
        this.messagePrefix = messagePrefix;
    }

    @Override
    public Optional<ConversationResponse> createConversation(ConversationRequest conversationRequest) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(messagePrefix, 
                conversationRequest.getPlayerName(),
                conversationRequest.getAggression(),
                conversationRequest.getInterceptions(),
                conversationRequest.getPositioning(),
                conversationRequest.getVision(),
                conversationRequest.getPenalties(),
                conversationRequest.getComposure(),
                conversationRequest.getQuestion()
                ));
        
        List<Message> messages = Arrays.asList(
            new Message("user", stringBuilder.toString())
        );
        
        ChatRequest request = new ChatRequest("gpt-3.5-turbo", messages);
        ResponseEntity<ChatResponse> chatResponse = client.createConversation(request, "Bearer " + apiKey);
        
        return Optional.of(ConversationResponse.builder().message(chatResponse.getBody().getChoices().get(0).getMessage().getContent()).build());
    }
    
}
