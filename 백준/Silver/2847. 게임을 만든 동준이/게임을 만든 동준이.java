import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		for(int i = 0; i < n; i++){
		    score[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i = n - 2; i >= 0; i--){
		    while(score[i] >= score[i + 1]){
		        score[i]--;
		        cnt++;
		    }
		}
		System.out.print(cnt);
	}
}
