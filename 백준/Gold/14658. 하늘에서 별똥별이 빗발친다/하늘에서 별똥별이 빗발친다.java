import java.io.*;
import java.util.*;
public class Main
{
    static Point[] star;
    static int n, m, l, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		star = new Point[k];
		for(int i = 0; i < k; i++){
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    star[i] = new Point(x, y);
		}
		int max = 0;
		for(int i = 0; i < k; i++){
		    int x = star[i].x;
            for(int j = 0; j < k; j++){
		        int y = star[j].y;
		        max = Math.max(max, count(x, y));
		    }
		}
		System.out.println(k - max);
	}
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int count(int x, int y){
        int cnt = 0;
        for(Point p : star){
            if(p.x >= x && p.x  <= x + l && p.y <= y && p.y >= y - l) cnt++;
        }
        return cnt;
    }
}
