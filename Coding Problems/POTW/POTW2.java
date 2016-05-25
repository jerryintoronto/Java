import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class POTW2 {
	
	static Queue <relationship> q = new LinkedList <relationship>();  //use a queue for BFS 
	static HashMap <String, Integer> aMap = new HashMap<String, Integer>(); //store name, relationship level
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int n = in.nextInt(); 
		
		while (n-- > 0) //read from system.in
			q.add(new relationship (in.next(), in.next()));

		
		aMap.put("Quinn", 0); //start with quinn 
		
		for (int i = 0; i < 100; i++) //remove from queue, if sees quinn or quinn's friend, remove 
		{
			relationship temp = q.poll(); 
			String p[] = temp.toString().split(" "); 
			if (aMap.containsKey(p[0]))
				aMap.put(p[1], aMap.get(p[0]) + 1);
			else if (aMap.containsKey(p[1]))
				aMap.put(p[0], aMap.get(p[1]) + 1); 
			else
				q.add(temp); 
			
		}
		
		while (!q.isEmpty()) //the people who are not at all connected to quinn
		{
			
			String p[] = q.poll().toString().split(" ");
			
			if (!aMap.containsKey(p[0]))
				aMap.put(p[0], -1);
			if (!aMap.containsKey(p[1]))
				aMap.put(p[1], -1);
			
		}
		
		
		Set<String> keys = aMap.keySet();  //printing the output 
		for (String s: keys)
		{
			System.out.print(s + " ");
			
			int temp = aMap.get(s);
			if (temp >= 0)
				System.out.println(temp);
			else
				System.out.println("uncool");
		}
		
		
	}
	
	static class relationship { 
		String p1; 
		String p2; 
		public relationship (String a, String b)
		{
			p1 = a; p2 = b; 
		}
		public String toString (){
			return p1 + " " + p2;
		}
	}

}
