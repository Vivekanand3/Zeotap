package com.example.ruleengine.model; 
 
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import java.util.Map; 
import java.util.Date; 
 
@Document(collection = "evaluations") 
public class Evaluation { 
    @Id 
    private String id; 
    private String userId; 
    private String ruleId; 
    private boolean result; 
    private Map<String, Boolean> evaluationDetails; 
    private Date createdAt; 
 
    // Constructors, Getters, and Setters... 
}