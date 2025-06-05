import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		long a = Long.parseLong(str[0]);
		long b = Long.parseLong(str[1]);
		long longA = a;
		long longB = b;
		long tmp;
		
		while( b != 0 ){

			tmp = a % b;
			a = b;
			b = tmp;

		}
		System.out.println(longA * longB / a);
	}
}
