// D4
// 1219. [S/W 문제해결 기본] 4일차 - 길찾기

import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int START = 0;
    static int END = 99;
    static int answer; //길 존재 여부, 존재하면 1, 없으면 0
    static int N; //길의 개수
    
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= 10; test_case++){	
			int Tnum = sc.nextInt();
            N = sc.nextInt();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            // map 초기화
			for(int i = 0; i < N; i++){
                int key = sc.nextInt();
                int value = sc.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                //key가 존재하지 않으면 list에 추가하여 put
                //key가 존재하면 해당 key의 value list에 추가하여 put
                list.add(value);
				if(map.containsKey(key)){
                	list = map.get(key);
                    list.add(value);
                }
            	map.put(key, list);
            }
			answer = 0;
            dfs(map, START);
            System.out.println("#" + Tnum + " " + answer);
		}
	}
    public static void dfs(Map<Integer, ArrayList<Integer>> map, int start){
    	// 이미 길을 찾았는데 반복하는 것을 피하기 위해 넣음
        if(answer == 1) return;
        if(start == END) {
        	answer = 1;
        	return;
        }
    	if(map.containsKey(start)){
            	dfs(map, map.get(start).get(0));
                if(map.get(start).size() == 2) {
                    dfs(map, map.get(start).get(1));
                }
        }
    }
}
