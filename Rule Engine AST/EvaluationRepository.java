package com.example.ruleengine.repository; 
import com.example.ruleengine.model.Evaluation; 
import org.springframework.data.mongodb.repository.MongoRepository; 
public interface EvaluationRepository extends MongoRepository<Evaluation, String> { 
}