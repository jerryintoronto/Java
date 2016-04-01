import java.util.Scanner;

//should use file redirection (can be set up in eclipse) 
public class POTW18 {
	public static void main(String[] args) {
		
		//Read and write header (first few lines)
		Scanner in = new Scanner(System.in);
		System.out.println(in.next());
		int x = in.nextInt(), y = in.nextInt();
		System.out.println(x + " " + y);
		System.out.println(in.next());
		
		//Read, change pixel to grey, and write
		int r, g, b, grey;
		for (int i = 1; i <= x * y; i++ )
		{
			r = in.nextInt(); 
			g = in.nextInt();
			b = in.nextInt();
			grey = (r + g + b) / 3; 
			
			System.out.print( grey + " " + grey + " " + grey  + " ");
			
			if (i % 6 == 0) System.out.println();
		}
		
		in.close();
		
	}
	
	
}
