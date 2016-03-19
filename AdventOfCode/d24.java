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

public class d24 {
	
		
	static ArrayList <Integer> all = new ArrayList <Integer> (); 
		
	static void storeData()  throws FileNotFoundException 
	{
		File file = new File("C:/Users/Jerry/workspace/Test/src/d24.txt");
		Scanner in = new Scanner(file);

		int i = 0; 
		int sum = 0; 
		while (in.hasNext())
		{
			int temp = in.nextInt();
			all.add(temp);
			sum+= temp;
			i++; 
		}
		
//		System.out.println("n = " + i); //29
//		System.out.println("sum = " + sum / 3); //sum = 512 for each 	
		
	}
	
	static void findMinComb()
	{
		boolean found = false; 
		for (int packages =  5; !found; packages++)
		{
//			for ()
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		storeData();
		
		
		
	}
}
