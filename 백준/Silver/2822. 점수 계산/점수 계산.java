import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int[] sortArr = new int[9];
		for(int i = 1; i < 9; i++){
		    arr[i] = Integer.parseInt(br.readLine());
		    sortArr[i] = arr[i];
		}
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		Arrays.sort(sortArr);
		for(int i = 1; i < 9; i++){
		    for(int j = 4; j < 9; j++){
		        if(arr[i] == sortArr[j]){
		            sum += arr[i];
		            sb.append(i).append(" ");
		        }
		    }
		}
		System.out.println(sum);
		System.out.print(sb);
	}
}
