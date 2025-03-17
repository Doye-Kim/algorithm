import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cntList = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int max = n > m ? n : m;
        int[] nameCnt = new int[n + m];
        int idx = 0;
        for(int i = 0; i < max; i++){
            if(i < n) nameCnt[idx++] = cntList[a.charAt(i) - 'A'];
            if(i < m) nameCnt[idx++] = cntList[b.charAt(i) - 'A'];
        }
        
        for(int i = n + m; i > 2; i--){
            for(int j = 0; j < i - 1; j++){
                nameCnt[j] = (nameCnt[j] + nameCnt[j + 1]) % 10;
            }
        }
        System.out.println(nameCnt[0] * 10 + nameCnt[1] +"%");
    }
}
