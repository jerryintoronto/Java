//import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 

public class d9 {
	
	static class nodes {
		String l1;
		String l2; 
		int distance; 
		double avg = -1;
		boolean notUsed = true; 
		
		public nodes (String l1, String l2, int distance) {
			this.l1 = l1; 
			this.l2 = l2; 
			this.distance = distance;
		}
		
		void test(nodes x)
		{
			this.distance = x.distance;
		}
		
		public void swap(nodes b)
		{
			String t1, t2; 
			int t3; 
			t1 = this.l1; 
			t2 = this.l2; 
			t3 = this.distance; 
			
			this.l1 = b.l1; 
			this.l2 = b.l2; 
			this.distance = b.distance; 
			
			b.l1 = t1; 
			b.l2 = t2; 
			b.distance = t3; 
		}
		
		public String toString()
		{
			return l1 + " " + l2 + " " + distance + "--- avg " + avg + "??" + notUsed; 
		}
	}
	
	static int d = 0;
	
	
	static void insertionSort(nodes all[], int len)
	{
		for (int i = 1; i < len; i++)
		{
			int k = i; 
			for (int j = i - 1; j >=0; j--)
			{
				nodes temp; 
				
				if (all[k].distance < all[j].distance)
				{
					all[k].swap(all[j]);
					k--;
				}
				
			}
			
			print(all); 
		}
	}
	
	
	
	static void print(nodes all[])
	{
		for (int i = 0; all[i] != null; i++)
		{
			System.out.print(all[i].distance + " ");
		}
		
		System.out.println();
	}

	static void calculateAll(nodes all[], int len, ArrayList<String>locations)
	{
		while(!locations.isEmpty())
		{
			System.out.println(locations.toString());
			refreshAvg(all, len, locations); 
			selectLowest(all, len, locations); 
		}
	}
	
	
	static void refreshAvg(nodes all[], int len, ArrayList<String>locations)
	{
		for (int i = 0; i < len; i++)
		{
			if (all[i].notUsed)
			{
				int count = 0; 
				if (locations.contains(all[i].l1))
					count++;
				if (locations.contains(all[i].l2))
					count++; 
				
				if (count == 0 || count == 1)
					all[i].avg = 1000;
				else
					all[i].avg = (double) all[i].distance / count; 
			}
		}
		
	}
	
	static void selectLowest(nodes all[], int len, ArrayList<String>locations)
	{
		double min = 100000;
		nodes minN = null; 
		for (int i = 0; i < len; i++)
		{
			if (all[i].notUsed)
			{
			
				if (all[i].avg < min)
					{ 
						min = all[i].avg; 
						minN = all[i];
					}
			}
		}
		
		//Part B - finish up 
		//can use another method 
		
		locations.remove(minN.l1);
		locations.remove(minN.l2);
		minN.notUsed = false; 
		d += minN.distance;
		
		//before returning lowest, test it 
		
		
	}
	
	static int getTotal(nodes all[], int len)
	{
		int total = 0;
		for (int i = 0; i < len; i++)
		{
			if (!all[i].notUsed)
			{
				total += all[i].distance;
			}
		}
		return total;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("This is working!!");
		
		nodes all[] = new nodes[100];
		
		
		
		ArrayList<String> locations = new ArrayList<String>(); 
		
		int total = 0; 
		File file = new File("C:/Users/jerry/workspace/Test/src/d9.txt");
		
		
		Scanner input = new Scanner(file); 
		int i = 0; 
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String temp[] = line.split(" "); 
			if (!locations.contains(temp[0]))
				locations.add(temp[0]);
			if (!locations.contains(temp[2]))
				locations.add(temp[2]);
			all[i] = new nodes(temp[0], temp[2], Integer.parseInt(temp[4])); 
			i++;
						
		}
		
//		print();
		insertionSort(all, i);
		calculateAll(all, i, locations);
		
		for (int a = 0; a < i; a++)
		{
			System.out.println(all[a].toString());
		}
		
		System.out.println(i);
		System.out.println(getTotal(all, i)); 
		System.out.println("????" + d);
	}

}
