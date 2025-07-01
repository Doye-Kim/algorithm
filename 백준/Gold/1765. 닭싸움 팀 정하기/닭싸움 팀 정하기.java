import java.util.*;
import java.io.*;
public class Main
{
    static int n, m, cnt;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> enemies = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
	    for(int i = 0; i <= n; i++){
	        friends.add(new ArrayList<>());
	        enemies.add(new ArrayList<>());
	    }
	    for(int i = 0; i < m; i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        char r = st.nextToken().charAt(0);
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        if(r == 'F') {
	            friends.get(a).add(b);
	            friends.get(b).add(a);
	        }
	        else if(r == 'E') {
	            enemies.get(a).add(b);
	            enemies.get(b).add(a);
	        }
	    }

	    for(int i = 1; i <= n; i++){
	        findWithEnemies(i);
	    }

	    for(int i = 1; i <= n; i++){
	        for(int a : friends.get(i)){
	            findWithFriends(i, a);
	        }
	    }
	    cnt = 0;
	    for(int i = 1; i <= n; i++){
	        if(visit[i]) continue;
	        findTeam(i);
	        cnt++;
        }
	    System.out.println(cnt);
	}
	static void findTeam(int i){
	    ArrayDeque<Integer> q = new ArrayDeque<>();
	    q.offer(i);
	    visit[i] = true;
	    while(!q.isEmpty()){
	        int now = q.poll();
    	    for(int a : friends.get(now)){
    	        if(visit[a]) continue;
    	        q.offer(a);
    	        visit[a] = true;
    	    }
	    }
	}
	static void findWithFriends(int origin, int newFriend){
	    if(friends.get(origin).contains(newFriend) || origin == newFriend) return;
        friends.get(origin).add(newFriend);
        friends.get(newFriend).add(origin);
        
        for(int a : friends.get(newFriend)){
            findWithFriends(origin, a);
        }
	}
	
	static void findWithEnemies(int origin){
        for(int a : enemies.get(origin)){
            for(int b : enemies.get(a)){
                if(friends.get(origin).contains(b) || b == origin) continue;
                friends.get(origin).add(b);
                friends.get(b).add(origin);
            }
        }
	}
	
}
