import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] map = new char[12][6];
	static boolean[][] visit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 12; i++) {
			String str = br.readLine();
			for(int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;
		while(true) {
			boolean flag = false;
			visit = new boolean[12][6];
            for(int i = 0; i < 12; i++) {
    			for(int j = 0; j < 6; j++) {
    				if(map[i][j] != '.' && !visit[i][j]) {
    				    if(bfs(i, j)) flag = true;
    				}
    			}
    		}
    		if(!flag) break;
    		down();
    		cnt++;
		}
		System.out.println(cnt);
	}
	
	static void down(){
	    for(int j = 0; j < 6; j++){
            ArrayDeque<Character> q = new ArrayDeque<>();
		    int idx = 11;
		    for(int i = 11; i >= 0; i--) {
			    if(map[i][j] != '.') {
				q.offer( map[i][j]);
				map[i][j] = '.';
			    }
		    }
    		while(!q.isEmpty()) {
    			char color = q.poll();
    			map[idx][j] = color;
    			idx--;
    		}
	    }
	}
	
    static boolean bfs(int y, int x) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		ArrayList<Node> list = new ArrayList<>();
	    Node nowNode = new Node(y, x);
	    char now = map[y][x];
	    
        q.offer(nowNode);
        list.add(nowNode);
        visit[y][x] = true;
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];
							
                if(nx < 0 || ny < 0 || ny >= 12 || nx >= 6 || visit[ny][nx] || map[ny][nx] != now) continue;
							
                Node newNode = new Node(ny, nx);
                q.offer(newNode);
                list.add(newNode);
                visit[ny][nx] = true;
			}
						
        }
					
        if(list.size() >= 4) {
            for(int k = 0; k < list.size(); k++) {
                int nx = list.get(k).x;
                int ny = list.get(k).y;
                
                map[ny][nx] = '.';
            }
            return true;
        }
        return false;
    }

	static class Node{
		int y, x;
		
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
