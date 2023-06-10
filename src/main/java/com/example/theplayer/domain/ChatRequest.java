package com.example.theplayer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChatRequest {

    private String model;
    private List<Message> messages;
    
    
}
