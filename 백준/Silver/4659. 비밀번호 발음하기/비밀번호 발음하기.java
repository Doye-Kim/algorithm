import java.io.*;
import java.util.*;
public class Main
{
    static char[] vowels = {'a', 'e', 'i','o', 'u'};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
		    String str = br.readLine();
		    if(str.equals("end")) break;
		    if(!containVowels(str) || isContinuous(str) || isRepeat(str)) {
		        sb.append("<").append(str).append("> is not acceptable.\n");
		    }
		    else sb.append("<").append(str).append("> is acceptable.\n");
		    
		}
		
		System.out.println(sb);
	}
	static boolean containVowels(String str){
	    for(int i = 0; i < str.length(); i++){
            for(int v = 0; v < 5; v++){
                if(str.charAt(i) == vowels[v]) return true;
            }
        }
        return false;
	}
	
	static boolean isContinuous(String str){
	    boolean prev = false;
	    int cnt = 0;
	    for(int i = 0; i < str.length(); i++){
	        boolean now = false;
            for(int v = 0; v < 5; v++){
                if(str.charAt(i) == vowels[v]) now = true;
            }
            if(prev != now){
                cnt = 1;
            }
            else cnt++;
            if(cnt >= 3) return true;
            prev = now;
        }
        return false;
	}
	static boolean isRepeat(String str){
	    int cnt = 1;
	    for(int i = 1; i < str.length(); i++){
            if(str.charAt(i - 1) == str.charAt(i)) cnt++;
            else cnt = 1;
            
            if(cnt >= 2 && str.charAt(i) != 'e' && str.charAt(i) != 'o') return true;
        }
        return false;
	}
}
