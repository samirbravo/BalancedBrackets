package com.bravi.service;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class BalancedBracketsService {
	
	public Boolean isValidSequence(String input) {
		
        Stack<Character> stack  = new Stack<Character>();
        
        for(int i = 0; i < input.length(); i++) {
            
        	Character character = input.charAt(i);
            
        	if(!isValidCharacter(character))
        		return false;
        	
            if(character == '[' || character == '(' || character == '{' ) {     
                stack.push(character);
            }else if(character == ']') {
            	if(stack.isEmpty() || stack.pop() != '[')
                	return false;
            }else if(character == ')') {
        		if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }else if(character == '}') {
            	if(stack.isEmpty() || stack.pop() != '{') 
                    return false;
            }
        }
        return stack.isEmpty();
    }
	
	public Boolean isValidCharacter(Character character) {
		if (character != '[' && character != '(' && character != '{' &&
			character != ']' && character != ')' && character != '}' ) {
			return false;
		}else {
			return true;
		}
	}
}
