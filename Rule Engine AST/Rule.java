create rule model 
                                                                                                                                                                                                                                
package com.example.ruleengine.model; 
 
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import java.util.Date; 
 
@Document(collection = "rules") 
public class Rule { 
    @Id 
    private String id; 
    private String name; 
    private String description; 
    private Node ast;  // AST representation 
    private Date createdAt; 
    private Date updatedAt; 
 
    public static class Node { 
        private String operator;  // AND, OR 
        private Node left;        // Left child 
        private Node right;       // Right child 
        private String operand;   // e.g., age, salary 
        private String comparator;  // >, <, == 
        private Object value;     // Value for comparison 
        // Getters and Setters... 
    } 
    // Constructors, Getters, and Setters... 
}