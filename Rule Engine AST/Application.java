package com.example.ruleengine.model; 
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import java.util.Map; 
import java.util.List; 
 
@Document(collection = "applications") 
public class Application { 
    @Id 
    private String id; 
    private String name; 
    private Map<String, Object> attributes;  // User attributes like age, salary, etc. 
    private List<String> associatedRules;    // Associated rule IDs 
    private String evaluationStatus; 
    // Constructors, Getters, and Setters... 
}