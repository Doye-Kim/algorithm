import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int q;
		long sum = 0;
		HashMap<String, PriorityQueue<Integer>> gorilla = new HashMap<>();
		
		// input
		q = Integer.parseInt(bf.readLine());
		for(int i = 0; i < q; i++) {
			String[] line = bf.readLine().split(" ");

			if(line[0].equals("1")) {
				PriorityQueue<Integer> c;
				if(gorilla.containsKey(line[1])) {
					c = gorilla.get(line[1]);
					for(int k = 0; k < Integer.parseInt(line[2]); k++) {
						c.add(Integer.parseInt(line[k + 3]));
					}
				}
				else {
					c = new PriorityQueue<>(Collections.reverseOrder());	
					for(int k = 0; k < Integer.parseInt(line[2]); k++) {
						c.add(Integer.parseInt(line[k + 3]));
					}
				}
				gorilla.put(line[1], c);
			}
			if(line[0].equals("2")) {
				if(!gorilla.containsKey(line[1])) continue;
				PriorityQueue<Integer> c = gorilla.get(line[1]);
				int size;
				if(c.size() < Integer.parseInt(line[2])) size = c.size();
				else size = Integer.parseInt(line[2]);
				for(int k = 0; k < size; k++){
					int a = c.poll();
					sum += a;
				}
			}
		}
		System.out.println(sum);
	}
}
