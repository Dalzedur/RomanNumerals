import static org.junit.Assert.fail;

import java.util.Scanner;

public class RomanNumerals 
{
	public static void main(String [] args)	
	{
		String inputs = null;		
		int arabic = 0;
		
		System.out.println("Roman numeral converter program.\n");
	    
		Scanner reader = new Scanner(System.in);
		System.out.println("Input the numeral: ");
	    inputs = reader.nextLine();
	    reader.close();

	    //now we have the roman numeral string as inputs

	    //let's scan it through and see that it is valid
		 for(int i = 0; i < inputs.length(); i++)
		 {
		 switch(inputs.charAt(i))
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
		  System.out.println("Not a valid roman numeral. "+inputs.charAt(i)+" does not belong.\n");
          System.exit(0);
		  }
		 }
	    
		//Further checking, do we have too many numerals in a row? Rule 1.
		if(inputs.contains("IIII"))
		{	
		System.out.println("Not a valid roman numeral. There can only be 3 I's in a row.\n");
		System.exit(0);
		}
		if(inputs.contains("XXXX"))
		{	
		System.out.println("Not a valid roman numeral. There can only be 3 X's in a row.\n");
		System.exit(0);
		}
		if(inputs.contains("CCCC"))
		{	
		System.out.println("Not a valid roman numeral. There can only be 3 C's in a row.\n");
		System.exit(0);
		}
		if(inputs.contains("MMMM"))
		{	
		System.out.println("Not a valid roman numeral. There can only be 3 M's in a row.\n");
		System.exit(0);
		}
	    
		//if V L or D gets repeated. Rule 2.
		if(inputs.contains("VV"))
		{	
		System.out.println("Not a valid roman numeral. There can't be more than 1 V in a row.\n");
		System.exit(0);
		}
		if(inputs.contains("LL"))
		{	
		System.out.println("Not a valid roman numeral. There can't be more than 1 L in a row.\n");
		System.exit(0);
		}
		if(inputs.contains("DD"))
		{	
		System.out.println("Not a valid roman numeral. There can't be more than 1 D in a row.\n");
		System.exit(0);
		}
		
		//The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest 
		//values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM'). Rule 3.    
		if(inputs.contains("IC") || inputs.contains("IL") || inputs.contains("ID") || inputs.contains("IM"))
		{	
		System.out.println("Not a valid roman numeral. When I precedes, only IV and IX are valid.\n");
		System.exit(0);
		}
		if(inputs.contains("XD") || inputs.contains("XM"))
		{	
		System.out.println("Not a valid roman numeral. When X undercuts, only XL and XC are valid.\n");
		System.exit(0);
		}

		//Only one subtraction allowed per numeral, XC is valid, XXC is not. Rule 4.
		if(inputs.contains("IIV") || inputs.contains("IIX") ||
		inputs.contains("XXC") || inputs.contains("CCD") || inputs.contains("CCM"))
		{	
		System.out.println("Not a valid roman numeral. No double undercutting.\n");
		System.exit(0);
		}
		
		//Rule 5: V, L, D can never be used to subtract.
		if(inputs.contains("VX") || inputs.contains("VL") || inputs.contains("VC") ||
		inputs.contains("VD") || inputs.contains("VM") || inputs.contains("LC") ||
		inputs.contains("LD") || inputs.contains("LM") || inputs.contains("DM"))		
		{	
		System.out.println("Not a valid roman numeral. V, L and D cannot undercut.\n");
		System.exit(0);
		}
		
		
	    //start of converting the values.
	    //start of C's
	    if(inputs.contains("CM"))
	    {
	    arabic += 900;
	    System.out.print(" 900");
	    }
	    if(inputs.contains("CD"))
	    {
        arabic += 400;
        System.out.print(" 400");
	    }
	    if(inputs.contains("CCC"))
	    {
	    arabic += 300;
	    System.out.print(" 300");
	    }
	    if(inputs.contains("CC") && !inputs.contains("CCC"))
	    {
 	    arabic += 200;
 	   System.out.print(" 200");
	    }
	    if(inputs.contains("C") && (!inputs.contains("CD") && !inputs.contains("CM")) &&
	     !inputs.contains("CCC") && !inputs.contains("CC") && !inputs.contains("XC"))
	    {
	    arabic += 100;
	    System.out.print(" 100");
	    } //end of C's

	    //D
	    if(inputs.contains("DCCC"))
	    {
	    arabic += 800;
	    System.out.print(" 800");
	    }
	    if(inputs.contains("DCC"))
	    {
	    arabic += 700;
	    System.out.print(" 700");
	    }
	    if(inputs.contains("DC"))
	    {
	    arabic += 600;
	    System.out.print(" 600");
	    }
	    if(inputs.contains("CD"))
	    {
	    arabic += 400;
	    System.out.print(" 400");
	    }
	    if(inputs.contains("D") && (!inputs.contains("CD") && !inputs.contains("DC")))
	    {
	    arabic += 500;
	    System.out.print(" 500");
	    }
	    
	    //start of X's
	    if(inputs.contains("XC"))
	    {
	    arabic += 90;
	    System.out.print(" 90");
	    }
	    else if(inputs.contains("XL"))
	    {
        arabic += 40;
        System.out.print(" 40");
	    }
	    else if(inputs.contains("XXX"))
	    {
	    arabic += 30;
	    System.out.print(" 30");
	    }
	    else if(inputs.contains("XX") && !inputs.contains("XXX"))
	    {
 	    arabic += 20;
 	   System.out.print(" 20");
	    }
	    else if(inputs.contains("X") && (!inputs.contains("XC") && !inputs.contains("XL")) &&
	     !inputs.contains("XXX") && !inputs.contains("XX"))
	    {
	    arabic += 10;
	    System.out.print(" 10");
	    } //end of X's
	    
	    //L
	    if(inputs.contains("L") && !inputs.contains("XL"))
	    {
	    arabic += 50;
	    System.out.print(" 50");
	    }
	    
	    //V
	    if(inputs.contains("IV"))
	    {
	    arabic += 4;
	    System.out.print(" 4");
	    }
	    else if(inputs.contains("V"))
	    {
	    arabic += 5;
	    System.out.print(" 5");
	    }

	    //I
	    if(inputs.contains("IX"))
	    {
	    arabic += 9;
	    System.out.print(" 9");
	    }
	    else if(inputs.contains("III"))
	    {
	    arabic += 3;
	    System.out.print(" 3");
	    }
	    else if(inputs.contains("II") && !inputs.contains("III"))
	    {
	    arabic += 2;
	    System.out.print(" 2");
	    }
	    else if(inputs.contains("I") && (
	    !inputs.contains("III") &&
	    !inputs.contains("II") && 
	    !inputs.contains("IV") && 
	    !inputs.contains("IX") )) 
	    {
	    arabic += 1;
	    System.out.print(" 1");
	    }
	    
	    //M
	    int count = inputs.length() - inputs.replace("M", "").length();
	    if(inputs.contains("CM"))
	    count--;
	    arabic += count*1000;
	    
	    System.out.print(" M-Count is: "+count+".\n");
	    System.out.print("Converted number is: "+arabic+".\n");
	    
		//CMDCXXXVIII = 900+600+30+8=1538
	    
	}
}
