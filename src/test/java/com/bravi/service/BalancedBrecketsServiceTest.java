package com.bravi.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bravi.BalancedBracketsApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BalancedBracketsApplication.class)
public class BalancedBrecketsServiceTest {

	@Autowired
	BalancedBracketsService balancedBracketService; 
	
	@Test
    public void sequenciesOfClosingBracketsMustBeValid() throws Exception {

		assertTrue(balancedBracketService.isValidSequence("(){}[]"));
    }
	
	@Test
    public void nestedClosingBracketsMustBeValid() throws Exception {

		assertTrue(balancedBracketService.isValidSequence("({[]})"));
    }
	
	@Test
    public void nestedAndSequenciesOfClosingBracketsMustBeValid() throws Exception {

		assertTrue(balancedBracketService.isValidSequence("[{()}](){}"));
    }
	
	@Test
    public void notClosingBracketShouldFail() throws Exception {

		assertFalse(balancedBracketService.isValidSequence("{"));
    }
	
	@Test
    public void notClosingBracketWithValidPairShouldFail() throws Exception {
				
		assertFalse(balancedBracketService.isValidSequence("[]{()"));
    }
	
	@Test
    public void unmatchedClosingBracketsShouldFail() throws Exception {

		assertFalse(balancedBracketService.isValidSequence("[{)]"));
    }
	
	@Test
    public void invalidCharactersShouldFail() throws Exception {

		assertFalse(balancedBracketService.isValidSequence("aaa"));
		assertFalse(balancedBracketService.isValidSequence("?@"));
		assertFalse(balancedBracketService.isValidSequence("{a}"));
		assertFalse(balancedBracketService.isValidSequence("(0)"));
    }

	@Test
    public void firstCharactersShouldBeAnOpenBracket() throws Exception {

		assertFalse(balancedBracketService.isValidSequence("}()"));
    }
	
	@Test
    public void matchedBracketsInWrongSequenceShouldFail() throws Exception {

		assertFalse(balancedBracketService.isValidSequence("}{"));
    }
	
	
}
