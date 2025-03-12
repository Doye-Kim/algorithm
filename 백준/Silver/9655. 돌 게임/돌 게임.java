import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // f(1) = sk, f(2) = cy, f(3) = sk, f(4) = cy, f(5) = sk
        // f(6) = cy, f(7) = sk, f(8) = cy
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}
