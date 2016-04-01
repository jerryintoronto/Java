import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class POTW17 {
	static PriorityQueue<node> pq = new PriorityQueue<node>(); //PriorityQueue is an always sorted Queue
	static HashMap<String, Integer> aMap = new HashMap<String, Integer>(); //counts the frequentcy of each word
	
	//---------------------------------------------------------------------------------------
	
	public static void main(String[] args) {

		// 1) console input
		Scanner in = new Scanner(System.in);
		String input = "", line = "";
		while(in.hasNextLine() && !( line = in.nextLine() ).equals( "" ))
			input += line;
		in.close();
		
		// 2) make a map of frequency for each word
		for (String s : input.split(" ")) {
			Integer val = aMap.get(s);
			if (val == null)
				aMap.put(s, 1);
			else
				aMap.put(s, val + 1);
		}

		// 3) transfer from a map to priorityQueue<node> , create node class (below) 
		for (Map.Entry<String, Integer> entry : aMap.entrySet()) 
			pq.add(new node(entry.getKey(), entry.getValue(), null, null));

		// 4) this is Huffman coding, tree created from bottom up, until there is 1 node left
		while (pq.size() >= 2) {
			node t1 = pq.poll();
			node t2 = pq.poll();
			pq.add(new node("Not Leaf", t1.freq + t2.freq, t1, t2));
		}

		// 5) traverse the tree, generate code, print output from the parent node left
		System.out.printf("\n\n%20s %20s %20s\n", "Word","Freq","Code"); 
		traverse(pq.poll(), ""); 
	}
	//---------------------------------------------------------------------------------------

	// user defined class node
	static class node implements Comparable<node> { 
		String word;
		int freq;
		node left, right;

		public node(String w, int a, node l, node r) {
			word = w;
			freq = a;
			left = l;
			right = r;
		}

		public int compareTo(node o) {
			return Integer.compare(freq, o.freq);
		}
	}
	
	//---------------------------------------------------------------------------------------

	//traverse the tree and generate code
	static void traverse(node n, String prefix) {
		
		if (n == null)
			return;
		
		traverse(n.left, prefix + "0");
		
		if (!n.word.equals("Not Leaf"))
			System.out.printf("%20s %20d %20s\n", n.word, n.freq, prefix); //outputs word and prefix 
		
		traverse(n.right, prefix + "1");
		
	}
}
