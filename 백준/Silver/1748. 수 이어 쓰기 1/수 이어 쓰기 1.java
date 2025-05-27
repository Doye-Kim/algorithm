import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(i < 10) ans += 1;
            else if(i < 100) ans += 2;
            else if(i < 1_000) ans += 3;
            else if(i < 10_000) ans += 4;
            else if(i < 100_000) ans += 5;
            else if(i < 1_000_000) ans += 6;
            else if(i < 10_000_000) ans += 7;
            else if(i < 100_000_000) ans += 8;
            else ans += 9;
        }
        System.out.print(ans);
	}
}
