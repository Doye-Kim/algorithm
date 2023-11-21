// D4
// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기

import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static HashMap<String, String> couple = new HashMap<>();
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		couple.put("(",")");
        couple.put("[","]");
        couple.put("{","}");
        couple.put("<",">");
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer = 0;
			int num = sc.nextInt();
            String string = sc.next();
            if(num % 2 == 0) {
                answer = test(string);
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
    static int test(String string){
        Stack<String> stack = new Stack<>();
        String[] st = string.split("");
        for(String s : st){
        	if(!s.equals(")") && !s.equals("}") && !s.equals(">") && !s.equals("]")){
            	stack.push(s);
            }
            if(s.equals(")") || s.equals("}") || s.equals(">") || s.equals("]")){
                //else 안 쓰는 버릇 들이려고 둘 다 if if로 하는데 이 두 개 순서 바뀌면 
                //peek()이 바뀌어서 값이 절대 제대로 안 나온다
                if(!(stack.peek().equals(getKey(couple, s)))){
                	return 0;
                }
                if(stack.peek().equals(getKey(couple, s))){
                	stack.pop();
                }
            }
        }
        if(stack.empty()) return 1;
        return 0;      
    }
}
