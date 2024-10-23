package com.example.ruleengine.repository; 
import com.example.ruleengine.model.Rule; 
import org.springframework.data.mongodb.repository.MongoRepository; 
public interface RuleRepository extends MongoRepository<Rule, String> { 
}