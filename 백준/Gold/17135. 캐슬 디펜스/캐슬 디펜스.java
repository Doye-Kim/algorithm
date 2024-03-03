
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	static int count, n, m, d, first, max;
	static int[] tgt;
	static int[][] map;
	static ArrayList<Loc> enemy;
	static ArrayList<Loc> originEnemy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		first = -1; // 적이 나오는 첫 행 
		// 성이 있는 칸에 궁수 3명 배치, 동시 공격
		// 거리가 D 이하인 적 중 가장 가까운, 가장 왼쪽의 적(턴마다 적 하나만 공격 가능)
		// 공격 받은 적은 게임에서 제외됨
		// 공격이 끝나면 적이 아래로 한 칸 이동
		// N+1 행엔 성이 있다. 성이 있는 칸으로 이동한 경우 제거됨
		// 한 자리에서 계속 공격
		// 모든 적이 격자판에서 제외되면 게임이 끝남
		// 이때 그냥 이동해서가 아니라 공격을 당해서 제외되는 적만 카운트
		max = 0;
		//count = 0;
		map = new int[n][m];
		tgt = new int[3];
		enemy = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					if(first == -1) first = i;
					enemy.add(new Loc(i, j));
				}
			}
		}
		comb(0,0);
		//n-first
		System.out.println(max);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) {
			count = 0;
//			System.out.println(Arrays.toString(tgt));
			if(enemy.size() == 0) enemy();
			game();
			enemy.clear();
			return;
		}
		for(int i = srcIdx; i < m; i++) {
			tgt[tgtIdx] = i;
			comb(i + 1, tgtIdx + 1);
		}
	}
	static void enemy() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					enemy.add(new Loc(i, j));
				}
			}
		}
	}
	static void game() {
		int f = first;
		HashSet<Loc> set = new HashSet<>();
		while(f < n) {
			for (int i = 0; i < 3; i++) { // 궁수들
				Loc a = new Loc(0, Integer.MAX_VALUE);
				a.setD(Integer.MAX_VALUE);
				for (int j = 0; j < enemy.size(); j++) { // 적들 중 가장 가깝고 왼쪽 고르기
					int nd = dist(new Loc(n, tgt[i]), enemy.get(j));
					if(nd <= d) {
						//System.out.println(enemy.get(j).die);
						if(enemy.get(j).die != 1 && enemy.get(j).x < n && (a.d > nd || (a.d == nd && (a.y > enemy.get(j).y)))) {
							a.x = enemy.get(j).x;
							a.y = enemy.get(j).y;
							a.d = nd;
						}
					}
				}
				if(a.y != Integer.MAX_VALUE) set.add(a);
			}
			for(Loc l : set) {
				//map[l.x][l.y] = 0;
				for(Loc e : enemy) {
					if(e.x == l.x && e.y == l.y) e.die = 1;
				}
			}
			count += set.size();
			//System.out.println("104 set: " + set);
			//System.out.println("size " + set.size());
			down();
			f++;
			set.clear();
			//System.out.println(Arrays.deepToString(map));
		}
		max = Math.max(count, max);
		//System.out.println("max: " + max);
		
		return;
	}
	static void down() {
//		for(int i = n-2; i >= 0; i--) {
//			map[i+1] = Arrays.copyOf(map[i], map[i].length);
//		}
//		Arrays.fill(map[0], 0);
		for(Loc l : enemy) {
			l.x++;
		}
		//System.out.println("123 enemy " + enemy);
	}
	static int dist(Loc a, Loc b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	static class Loc{
		int x, y, d, die;

		public void setD(int d) {
			this.d = d;
		}

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			//this.die = false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Loc other = (Loc) obj;
			return x == other.x && y == other.y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + ", d=" + d + ", die=" + die + "]";
		}
	}
}