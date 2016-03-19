import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class POTW16 {
	

	public static void main(String[] args) {
	    
		setUp();
	    useQueueToFindMin();
	}


	static int board[] = new int [110]; 
	
	
	static class move {
		int position; 
		int turn; 
		
		public move(int pos, int t)
		{
			position = pos; 
			turn = t;
		}
	}
	
	static void setUp(){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	    
	    //sets up board
	    for (int i = 1; i < 110; i++)
	    	board[i] = i;
	
	    //adds special events by reading from console input 
	    for (int i = 0; i < n ; i++)
	    	board[in.nextInt()] = in.nextInt(); 
		
	}
	
	static void useQueueToFindMin(){
		
		Queue <move> all = new LinkedList <move>(); 
		boolean visited[] = new boolean[100]; //signicantly reduces calculation time if turns is > 7 or so
		  
	    //starting out
		all.add(new move(1,0));
	    
	    
	    while (!all.isEmpty()) {
	    	
	    	move temp = all.remove(); 		
		
			for (int dice = 1; dice <= 6; dice++) {
				int newPosition = board[temp.position + dice];
				if (newPosition >= 100) //end reached 
				{ 
					System.out.println("turns needed: " + (temp.turn + 1));
					return;
				}
				
				if (!visited[newPosition]) //only add if not already visited! 
				{
					all.add(new move(newPosition, temp.turn + 1));
					visited[newPosition] = true; 					
				}
				
			}
		}
	    
	    System.out.println("No solution!");
		
	}
	
}
