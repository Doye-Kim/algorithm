import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < n; i++){
		    set.add(Integer.parseInt(st.nextToken()));
		}
		n = set.size();
		int[] nums = new int[n];
		int idx = 0;
		for(int num : set){
		    nums[idx++] = num;
		}
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
		    sb.append(nums[i]).append(" ");
		}
		System.out.print(sb);
	}
}
