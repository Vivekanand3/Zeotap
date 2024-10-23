Rule Evaluation Logic:  package com.example.ruleengine.service; 
import com.example.ruleengine.model.Application; 
import com.example.ruleengine.model.Rule; 
import org.springframework.stereotype.Service; 
@Service 
public class RuleEngine { 
// Evaluate a rule's AST against user data 
public boolean evaluateRule(Rule.Node ast, Application application) { 
        if (ast == null) return true; 
 
        if (ast.getOperator() != null) { 
            switch (ast.getOperator()) { 
                case "AND": 
                    return evaluateRule(ast.getLeft(), application) && evaluateRule(ast.getRight(), 
application); 
                case "OR": 
                    return evaluateRule(ast.getLeft(), application) || evaluateRule(ast.getRight(), application); 
            } 
        } 
 
        // Operand node evaluation 
        String attribute = ast.getOperand(); 
        Object userValue = application.getAttributes().get(attribute); 
        Object ruleValue = ast.getValue(); 
 
        switch (ast.getComparator()) { 
            case ">": 
                return (Integer) userValue > (Integer) ruleValue; 
            case "<": 
                return (Integer) userValue < (Integer) ruleValue; 
            case "==": 
                return userValue.equals(ruleValue); 
            default: 
                return false; 
        } 
    } 
}