import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class day13 {
	
	static ArrayList <String> people = new ArrayList();
	static Nodes data[] = new Nodes[1000];
	
//	static int happiness ()
	
	//permutation - get all possibilities of seat arrangement 
	//find happiness for each arrangement 
	//store max happiness 
	
	public static class Nodes{
		String p1; 
		String p2; 
		int happiness = 0;
		
		public Nodes (String p1, String p2) {
			this.p1 = p1; 
			this.p2 = p2; 
		}
		
		public boolean contains(String p1, String p2)
		{
			
			if (this.p1.equals(p1) && this.p2.equals(p2))
				return true;
			else if (this.p1.equals(p2) && this.p2.equals(p1))
				return true;
			
			return false; 
		}
		
		public void set(int h)
		{
			this.happiness = h; 
		}
		public int get()
		{
			return this.happiness; 
		}
		public String toString()
		{
			return p1 + " " + p2 + " " + happiness; 
		}
	}
	
	static int calculate(String str)
	{
		int total = 0; 
		for (int i =0 ; i < str.length(); i++)
		{
//			System.out.print(" " + total + " ");
//			System.out.print(people.toString());
			
			String p1 = people.get((int) str.charAt(i) - '0');
			int i2 = (int) ((str.charAt((i + 1) % str.length() ) - '0') ); 
			String p2 = people.get(i2);
			
//			System.out.print(str.charAt(i) + " " +  p1 + " : " + i2 + " "  + p2);
			
			
			for (int j = 0; data[j] != null; j++)
			{
				if (data[j].contains(p1,p2))
				{
					total += data[j].get();
//					System.out.println(data[j].get());
				}
			}
		}
		
		System.out.print(" " + total + " ");
		return total;
	}

	static int max = 0; 
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
 
	    if (n == 0) 
    	{
//	    	System.out.print(prefix + " ");
	    	int temp = calculate(prefix); 
//	    	System.out.println(temp + " ");
	    	if (temp > max) max = temp; 
	    	System.out.println("max: " + max);
    	}
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File ("C:/Users/jerry/Desktop/Java/Jan5/src/d13.txt");
		Scanner in = new Scanner(file); 
		
		
		
		int i = 0; 
		
		while (in.hasNext()){
			String str = in.nextLine();
//			System.out.println(str);
			String parts[] = str.split(" ");
			if (!people.contains(parts[0]))
				people.add(parts[0]);
//			System.out.println(parts[0] + " " + parts[2] + " " + parts[3] + " " + parts[10]);
			data[i] = new Nodes(parts[0], parts[10].substring(0, parts[10].length()-1)); 
			if (parts[2].equals("gain"))
				data[i].set(Integer.parseInt(parts[3]));
			else
				data[i].set(Integer.parseInt(parts[3])*-1);
			i++;
		}
		
		try {
		for (Nodes x: data)
			System.out.println(x.toString());
		} catch (Exception e) {};
		
		System.out.println("!!!" + i + "!!!!");
		
		people.add("me");
		
		for (int a = 0; a < people.size() - 1; a++)
		{
			data[i++] = new Nodes("me",people.get(a));
		}
		
		
		System.out.println(people.toString());
		
		day13 eh = new day13();
		eh.permutation("", "012345678");
		System.out.println(eh.max);
	}
}
