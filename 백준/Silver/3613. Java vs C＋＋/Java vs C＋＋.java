import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String str;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		boolean cpp = false, java = false, both = true;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(0)) || str.charAt(0) == '_' || str.charAt(str.length()-1) == '_') {
				cpp = false;
				java = false;
				both = false;
				break;
			}
			if(str.charAt(i) == '_') {
				if(str.charAt(i-1) == '_') {
					cpp = false;
					java = false;
					both = false;
					break;
				}
				cpp = true;
				both = false;
			}
			if(Character.isUpperCase(str.charAt(i))) {
				java = true;
				both = false;
			}
		}
		
		if((cpp && java) || (!cpp && !java && !both)) sb.append("Error!");
		else if(both) sb.append(str);
		else if(cpp && !java) {
			cppToJava();
		}
		else if(!cpp && java){
			javaToCpp();
		}
		System.out.println(sb);

	}
	static void cppToJava() {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '_') {
				sb.append(Character.toUpperCase(str.charAt(++i)));
				continue;
			}
			sb.append(str.charAt(i));
		}
	}
	static void javaToCpp() {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				sb.append('_');
				sb.append(Character.toLowerCase(str.charAt(i)));
				continue;
			}
			sb.append(str.charAt(i));
		}
	}

}
