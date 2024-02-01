import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, P, ans;
	static char[] dna;
	static int minA, minC, minG, minT;
	// A-T 빈도수 배열 (4개 제외 나머지는 걍 dummy)
	static int[] cnt = new int[20];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());
		
		solve();
		System.out.println(ans);
	}

	// 문자열을 쭉 처리하면서 유효한지 검증
	static void solve() {
		// 맨 앞 P개 처리 <= P개 중 ACGT에 해당하는 문자이면 각각 해당하는 cntA, ... , cntT 를 증가
		for(int i = 0; i < P; i++) cnt[dna[i] - 'A']++;
		check();
		// P 이후 한 개씩 처리
		// 이전 P 개 중 맨 앞 문자 제거 -> 새 문자가 맨 뒤에 추가
		for(int i = P; i < S; i++) {
			// 맨 앞 제거
			cnt[dna[i - P] - 'A']--;
			// 맨 뒤 추가
			cnt[dna[i] - 'A']++;

			check();
		}
	}
	// 현재 각 문자의 cnt 가 최소 조건을 만족하는지 확인 후 ans 증가
	static void check() {
		if(cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT) ans++;
	}
}
