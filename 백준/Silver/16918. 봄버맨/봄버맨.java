import java.util.*;
import java.io.*;

public class Main
{
    static int r, c, n;
    static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		r = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		n = Integer.parseInt(arr[2]);
		
		map = new char[r][c];
		for(int i = 0; i < r; i++){
		    String str = br.readLine();
		    for(int j = 0; j < c; j++){
		        map[i][j] = str.charAt(j);
		    }
		}
		StringBuilder sb = new StringBuilder();
		if(n % 2 == 0){
		    for(int i = 0; i < r; i++){
		        for(int j = 0; j < c; j++){
		            sb.append('O');
		        }
		        sb.append("\n");
		    }
		}
		else{
		    for(int i = 0; i < (n / 2); i++){
		        bomb();
		    }
		    for(int i = 0; i < r; i++){
		        for(int j = 0; j < c; j++){
		            sb.append(map[i][j]);
		        }
		        sb.append("\n");
		    }
		}
		System.out.print(sb);
	}
	static void bomb(){
        HashSet<Point> set = new HashSet<>();
	    for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 'O'){
                    set.add(new Point(i, j));
                    set.add(new Point(i + 1, j));
                    set.add(new Point(i - 1, j));
                    set.add(new Point(i, j + 1));
                    set.add(new Point(i, j - 1));
                }
            }
	    }
	    for(int i = 0; i < r; i++){
	        Arrays.fill(map[i], 'O');
	    }
	    for(Point p : set){
            int px = p.x;
            int py = p.y;
	        if(py < 0 || px < 0 || py >= r || px >= c) continue;
	        
	        map[py][px] = '.';
	    }
	}
	static class Point{
	    int y, x;
	    public Point(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	    public boolean equals(Object o){
	        Point point = (Point)o;
	        return point.y == this.y && point.x == this.x ? true : false;
	    }
	}
}
