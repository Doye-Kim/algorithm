import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        
        int cx = (p + t) % (2 * w);
        int cy = (q + t) % (2 * h);
        
        if(cx > w) cx = 2 * w - cx;
        if(cy > h) cy = 2 * h - cy;
        
        StringBuilder sb = new StringBuilder();
        sb.append(cx).append(" ").append(cy);
        System.out.println(sb);
        
    }
}
