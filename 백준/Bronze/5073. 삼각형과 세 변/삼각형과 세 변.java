import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] num = new int[3];
		while(true){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    num[0] = Integer.parseInt(st.nextToken());
		    num[1] = Integer.parseInt(st.nextToken());
		    num[2] = Integer.parseInt(st.nextToken());
		    
		    if(num[0] == 0 && num[1] == 0 && num[2] == 0) break;
		    Arrays.sort(num);
		    if(num[2] < num[0] + num[1]){
		        if(num[0] == num[1] && num[1] == num[2]) sb.append("Equilateral\n");
		        else if(num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) sb.append("Scalene\n");
		        else sb.append("Isosceles\n");
		    }
		    else sb.append("Invalid\n");
		}
		System.out.println(sb);
	}
}
