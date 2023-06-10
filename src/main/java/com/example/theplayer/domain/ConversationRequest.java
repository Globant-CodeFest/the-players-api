package com.example.theplayer.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversationRequest {
    
    private String playerName;
    private String positioning;
    private String interceptions;
    private String aggression;
    private String vision;
    private String penalties;
    private String composure;
    private String question;
    
}
