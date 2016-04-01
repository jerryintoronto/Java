//import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 

public class day17 {
	static ArrayList <Integer> arr = new ArrayList <Integer>(); 
	static int counter = 0; 
	static int min = 20; 
	
	static void calculate(String s)
	{
		int sum = 0; 
		int minC = 0; 
		for (int i = 0; i < s.length(); i++)
		{
			int oneOrZero = (int) s.charAt(i) - '0';
			if (oneOrZero == 1) minC++; 
			sum += oneOrZero * arr.get(i);
			
		}
		if (sum == 150 && minC == 4) 
		{
			counter++;
		}
		
	}
	
	
	
	
	public static void printBin(String soFar, int iterations) {
	    if(iterations == 0) {
//	        System.out.println(soFar);
	    	calculate(soFar); 
	    }
	    else {
	        printBin(soFar + "0", iterations - 1);
	        printBin(soFar + "1", iterations - 1);
	    }
	}
		
	public static void main(String[] args) throws FileNotFoundException {
	
		File file = new File ("C:/Users/jerry/Desktop/Java/Jan5/src/d17.txt");
		Scanner in = new Scanner(file);
		
		
		int i = 0; 
		
		while (in.hasNext()){
			String str = in.nextLine();
			arr.add(Integer.parseInt(str));
		}
		
		System.out.println(arr.size());
		
		printBin("",20);
		
		System.out.println(counter + " " + min);
	}
	
}
