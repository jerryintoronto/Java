import java.util.Scanner;

public class POTW19 {
	
	static Nodes root = new Nodes(0); 
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		String line = "";
		
		//1. read from input
		while (in.hasNextLine() && !((line=in.nextLine()).equals(""))){
		
			Nodes cur = root; 
			int i = 0;
		
			//2. build tree - code node must be a leaf node 
			for (; i < line.length() - 1; i++) {
				
				// let 0 be left branch 
				if (line.charAt(i)=='0') {
					if (cur.left == null)
						cur.left = new Nodes(0);
					
					cur = cur.left;
				}
			
				// else its 1, right branch
				else {
					if (cur.right == null)
						cur.right = new Nodes(0);
					
					cur = cur.right;
				}
				
				if (cur.x == 1) {
					System.out.println("False");
					return;
				}

			}
			
			//add code node to tree
			if (line.charAt(i) == '0' && cur.left == null)
				cur.left = new Nodes(1);
			else if(line.charAt(i) == '1' && cur.right == null)
				cur.right = new Nodes(1); 
			else //something is already here
			{
				System.out.println("False");
				return; 
			}
		}
		in.close();
		System.out.println("True");
		return;
	}
	
	static class Nodes {
		Nodes left; 
		Nodes right; 
		int x; //let value of 1 = a code node, 0 otherwise  
		
		public Nodes (int n)
		{
			x = n;
		}
	}
}
