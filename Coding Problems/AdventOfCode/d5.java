import java.util.Scanner;

public class day5 {
	
	static boolean countCheck (String s)
	{
		int vowelCount = 0; 
		for (int i =0; i < s.length(); i++)
		{
			switch(s.charAt(i))
			{
				case 'a': 
				case 'e': 
				case 'i':
				case 'o':
				case 'u': 
					vowelCount++; 
					break; 
			}
		}
		return (vowelCount>=3) ? true : false;
		
	}
	
	static boolean doubleCheck (String s)
	{
		char pre = s.charAt(0); 
		for (int i =1; i <s.length(); i++)
		{
			if (s.charAt(i) == pre)
				return true; 
			pre = s.charAt(i);
		}
		
		return false; 
	}
	
	static boolean passThirdCheck (String s)
	{
		
		String badWords[] = {"ab", "cd", "pq", "xy"};
		
		for (int i = 0; i < badWords.length; i++)
			if (s.indexOf(badWords[i]) >= 0)
				return false;
		return true; 
	}
	
	static boolean fourthCheck (String s)
	{
		int count = 0; 
		for (int i = 0; i < s.length() -2; i++)
		{
			String str = s.substring(i, i+2);  
			String remainder = s.substring(i+2);  
			if (remainder.indexOf(str) >= 0) 
				return true;
			
		}
				
		return false;
	}
	
	static boolean fifthCheck (String s)
	{
		char a = s.charAt(0); 
		char b = s.charAt(1); 
		
		for (int i = 2; i < s.length() ; i++)
		{
			if (s.charAt(i) == a)
				return true; 
			a = b; 
			b = s.charAt(i); 
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in); 
		String line = "";
		int count = 0; 
		
		while (stdin.hasNextLine() && !(line = stdin.nextLine()).equals(""))
		{
			//System.out.println(line);
			
			//if (countCheck(line) && doubleCheck(line) && passThirdCheck(line))
				//count++;
			
			if (fourthCheck(line) && fifthCheck(line))
			{
				count++;
			}
			
			//System.out.println(fifthCheck(line));
			//System.out.println(fourthCheck(line));
			//System.out.println(passThirdCheck(line));
			//System.out.println(doubleCheck(line));
			//System.out.println(countCheck(line));
		}
		
		
		
		
		System.out.println(count);
		
	}
}
