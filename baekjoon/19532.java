import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = bf.readLine(); //String
		
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
		int a = Integer.parseInt(st.nextToken()); //첫번째 호출
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if(a * x + b * y == c && d * x + e * y == f) {
					System.out.print(x + " " + y);
				}
			}
		}
		bf.close();
	}
}
