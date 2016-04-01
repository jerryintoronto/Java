import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class d23 {
	
	static long a = 1; 
	static int b = 0; 
	static int i = 0; 
	
	public static void process(ArrayList <String []> all)
	{
	
		String arr[] = all.get(i);
//		System.out.println(i + " " + arr[0] + " a: " + a + " b: " + b);
		
	
		if (arr[0].equals("hlf"))
		{
			if (arr[1].equals("a")) 
				a /= 2;
			else
				b /= 2; 
			
			i++;
		}
		
		else if (arr[0].equals("tpl"))
		{
			if (arr[1].equals("a"))
				a *= 3; 
			else
				b *= 3;
			
			i++; 
		}
		else if (arr[0].equals("inc"))
		{
			
			if (arr[1].equals("a"))
				a++;
			else
				b++;
			
			i++; 
			
		}
		
		else if (arr[0].equals("jmp"))
		{
			int amount = Integer.parseInt(arr[1].substring(1));
			if (arr[1].charAt(0) == '-') amount *= -1; 
			i += amount; 
		}
					
		else if (arr[0].equals("jie"))
		{
			int amount = Integer.parseInt(arr[2].substring(1));
			if (arr[2].charAt(0) == '-') amount *= -1; 
			if (arr[1].charAt(0) == 'a' && a%2 == 0)
				i += amount;
			else if (arr[1].charAt(0) == 'b' && b%2 == 0)
				i += amount;
			else
				i++;
			
		}
		
		else if (arr[0].equals("jio"))
		{
			int amount = Integer.parseInt(arr[2].substring(1));
			if (arr[2].charAt(0) == '-') amount *= -1; 
			if (arr[1].charAt(0) == 'a' && a == 1)
				i += amount;
			else if (arr[1].charAt(0) == 'b' && b == 1)
				i += amount;
			else
				i++; 
			
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		ArrayList <String []> all = new ArrayList <String []> (); 
		
		File file = new File("C:/Users/Jerry/workspace/Test/src/d23.txt");
		Scanner in = new Scanner(file);

		
		while (in.hasNext()) 
			all.add(in.nextLine().split(" "));
		
		while (i < all.size())
		{			
			process(all);
		}
		
		System.out.println(b);
		
		
	}
}
