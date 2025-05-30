import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(br.readLine());
	    Delivery[] delivery = new Delivery[m + 1];
	    delivery[0] = new Delivery(0, 0, 0);
	    for(int i = 1; i <= m; i++){
	        st = new StringTokenizer(br.readLine());
	        int start = Integer.parseInt(st.nextToken());
	        int end = Integer.parseInt(st.nextToken());
	        int box = Integer.parseInt(st.nextToken());
	        delivery[i] = new Delivery(start, end, box);
	    }
	    Arrays.sort(delivery);
	    
	    int sum = 0;
	    
	    int[] town = new int[n];
	    Arrays.fill(town, c);
	    
	    for(int i = 1; i <= m; i++){
	        Delivery d = delivery[i];
            int min = Integer.MAX_VALUE;
            for(int j = d.start; j < d.end; j++){
                min = Math.min(min, town[j]);
            }

	        if(min >= d.box){
	            for(int j = d.start; j < d.end; j++){
                    town[j] -= d.box;
                }
                sum += d.box;
	        }
	        else {
	            for(int j = d.start; j < d.end; j++){
                    town[j] -= min;
                }
                sum += min;
	        }
	    }
	    System.out.println(sum);
	}
	static class Delivery implements Comparable<Delivery>{
	    int start, end, box;
	    public Delivery(int start, int end, int box){
	        this.start = start;
	        this.end = end;
	        this.box = box;
	    }
	    @Override
	    public int compareTo(Delivery d){
	        return this.end == d.end ? this.start - d.start : this.end - d.end;
	    }
	}
}
