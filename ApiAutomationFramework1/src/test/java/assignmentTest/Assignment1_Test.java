package assignmentTest;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.Test;

import assisgnments.Assignments_1;

public class Assignment1_Test {
	@Test
	  public void emptyString() {
		  
			    String input = "A"; 
			    int[] expectedCounts = new int[128];
			    expectedCounts ['A']=1;
			    int[] counts =  Assignments_1.countCharacter(input);
			    
			    assertArrayEquals(expectedCounts, counts);
			  }
	@Test
	  public void testMultipleCharacters() {
	    String input = "abcda";
	    int[] expectedCounts = new int[128];
	    expectedCounts['a'] = 2;
	    expectedCounts['b'] = 1;
	    expectedCounts['c'] = 1;
	    expectedCounts['d'] = 1;
	    
	    int[] counts = Assignments_1.countCharacter(input);
	    
	    assertArrayEquals(expectedCounts, counts);
	}
	@Test
	  public void testWithDigitsAndSpecialChars() {
	    String input = "a1$c2#d";
	    int[] expectedCounts = new int[128];
	    expectedCounts['a'] = 1;
	    expectedCounts['1'] = 1;
	    expectedCounts['$'] = 1; 
	    expectedCounts['c'] = 1;
	    expectedCounts['2'] = 1;
	    expectedCounts['#'] = 1;
	    expectedCounts['d'] = 1;

	    int[] counts = Assignments_1.countCharacter(input);

	    assertArrayEquals(expectedCounts, counts);
	  }

}
