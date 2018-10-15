import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestRomanNumerals 
{

	@Test
	public void testValidString() 
	{
     //checks that a string does not contain invalid roman numerals
	 String testString = "MMCDLXXIV";
	 	 	 
	 for(int i = 0; i < testString.length(); i++)
	 {
	 switch(testString.charAt(i))
	  {
	 case 'i':
	 case 'I':
	 break;
	 case 'v':
	 case 'V':
	 break;
	 case 'x':
	 case 'X':
	 break;
	 case 'l':
	 case 'L':
	 break;
	 case 'c':
	 case 'C':
	 break;
	 case 'd':
	 case 'D':
	 break;
	 case 'm':
	 case 'M':
	 break;
	 default:
		fail("Char '"+testString.charAt(i)+"' not valid roman numeral");
	  }
	 }
    }

 @Test
 public void testRule1()
 {
	 String testString = "MMCDLXXIV";
	 
		if(testString.contains("IIII"))
		{		
		fail("Not a valid roman numeral. There can only be 3 I's in a row.\n");		
		}
		if(testString.contains("XXXX"))
		{
		fail("Not a valid roman numeral. There can only be 3 X's in a row.\n");			
		}
		if(testString.contains("CCCC"))
		{	
		fail("Not a valid roman numeral. There can only be 3 C's in a row.\n");			
		}
		if(testString.contains("MMMM"))
		{	
		fail("Not a valid roman numeral. There can only be 3 M's in a row.\n");			
		}
	 
 }
 
 @Test
 public void testRule2()
 {
	 String testString = "MMCDLXXIV";
	 
		if(testString.contains("VV"))
		{	
		fail("Not a valid roman numeral. There can't be more than 1 V in a row.\n");
		}
		if(testString.contains("LL"))
		{
		fail("Not a valid roman numeral. There can't be more than 1 L in a row.\n");			
		}
		if(testString.contains("DD"))
		{	
		fail("Not a valid roman numeral. There can't be more than 1 D in a row.\n");	
		}
	 
 }
 
 @Test
 public void testRule3()
 {
	 String testString = "MMCDLXXIV";

	if(testString.contains("IC") || testString.contains("IL") || testString.contains("ID") || 
			testString.contains("IM"))
		{	
		fail("Not a valid roman numeral. When I precedes, only IV and IX are valid.\n");		
		}
		if(testString.contains("XD") || testString.contains("XM"))
		{	
		fail("Not a valid roman numeral. When X undercuts, only XL and XC are valid.\n");		
		}
	 
 }
 
 @Test
 public void testRule4()
 {
	String testString = "MMCDLXXIV";

	if(testString.contains("IIV") || testString.contains("IIX") ||
	testString.contains("XXC") || testString.contains("CCD") || testString.contains("CCM"))
		{	
		fail("Not a valid roman numeral. No double undercutting.\n");		
		}
	 
 }
 @Test
 public void testRule5()
 {
	 String testString = "MMCDLXXIV";

	if(testString.contains("VX") || testString.contains("VL") || testString.contains("VC") ||
	testString.contains("VD") || testString.contains("VM") || testString.contains("LC") ||
	testString.contains("LD") || testString.contains("LM") || testString.contains("DM"))		
		{	
		fail("Not a valid roman numeral. V, L and D cannot undercut.\n");		
		}
	 
 }
}
