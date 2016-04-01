import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class day14 {
	
	static ArrayList <Nodes> all = new ArrayList<Nodes>();
	
	static class Nodes {
		String name; 
		int speed;
		int time;
		int rest; 
		int score = 0; 
		int distance; 
		
		public Nodes(String name, int speed, int time, int rest)
		{
			this.name = name;
			this.speed = speed;
			this.time = time;
			this.rest = rest; 
		}
		
		public void addScore()
		{
			this.score++; 
		}
		
		public String toString()
		{
			return name + " " + score;
		}
	}
	
	
	static int min (int a, int b)
	{
		if (b > a)
			return a;
		else 
			return b;
		
	}
	
	static int calculate(int speed, int time, int rest, int totalTime)
	{
		int segment = (time + rest);
		int loops = totalTime / segment; 
		int timeRemain = totalTime - loops * segment;  
		
		return loops * speed * time + min(time,timeRemain) * speed;
		
	}
	
	Map score = new HashMap();
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File ("C:/Users/jerry/Desktop/Java/Jan5/src/d14.txt");
		Scanner in = new Scanner(file); 
		
		while (in.hasNext()){
			String str = in.nextLine();
			String parts[] = str.split(" ");
			String name = parts[0];
			int speed = Integer.parseInt(parts[3]);
			int time = Integer.parseInt(parts[6]);
			int rest = Integer.parseInt(parts[13]);
			
			all.add(new Nodes(name,speed,time,rest));		
		}
		
		
		for (int i = 1;i<2504;i++) {
			
			int max = 0;
			
			for (int j = 0; j < all.size(); j++) {
				int speed = all.get(j).speed; 
				int time = all.get(j).time; 
				int rest = all.get(j).rest; 
				
				int result = calculate(speed, time, rest, i);
				all.get(j).distance = result; 
				
				if (result > max) {
					max = result;
				}
			}
			
			//add score
			for (int j = 0; j < all.size(); j++) {
				if (all.get(j).distance == max)
				{
					all.get(j).addScore();
				}
			}
		}
		
		
		int sumCheck = 0; 
		for (int i =0; i<all.size(); i++)
		{
			System.out.println(all.get(i));
			sumCheck += all.get(i).score; 
		}
		
		System.out.println(sumCheck);
		
		
		
		
		
	}
}
