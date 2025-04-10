import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
		    String str = br.readLine();
		    if(str.equals("end")) break;
		    boolean flag = false;
		    char prev = '-';
		    int cnt = 0;
		    for(int i = 0; i < str.length(); i++){
		        char now = str.charAt(i);
		        if(isVowel(now)) flag = true;
		        
		        if(isVowel(prev) != isVowel(now)) cnt = 1;
		        else cnt++;
		        
		        if(cnt == 2 && prev == now && now != 'e' && now != 'o') {
		            flag = false;
		            break;
		        }
		        if(cnt >= 3) {
		            flag = false;
		            break;
		        }
		        prev = now;
		    }
		    if(!flag) {
		        sb.append("<").append(str).append("> is not acceptable.\n");
		    }
		    else sb.append("<").append(str).append("> is acceptable.\n");
		    
		}
		
		System.out.println(sb);
	}
	static boolean isVowel(char a){
	    if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') return true;
	    return false;
	}
}
