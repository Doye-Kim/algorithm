import java.util.*;
import java.io.*;

class Solution
{
  static int sum;
	public static void main(String args[]) throws Exception
	{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
      //변수 초기화
			String[] a = bf.readLine().split(" ");
      String[] b = bf.readLine().split(" ");
      int v = Integer.parseInt(a[0]);
      int e = Integer.parseInt(a[1]);
      String n = a[2];
      String m = a[3];
      Map<String, String> nodes = new HashMap<>(); //자식-부모순, 공통 조상을 찾기 위함
      Map<String, ArrayList<String>> map = new HashMap<>(); // 부모-자식노드들, 서브트리 개수 세기 위함
            
      for(int i = 0; i < e * 2; i+=2){
          nodes.put(b[i + 1], b[i]);
          ArrayList<String> list = new ArrayList<>();
          map.getOrDefault(b[i],  list).add(b[i + 1]);
          map.put(b[i], map.getOrDefault(b[i],  list));
      }
      
      //가장 가까운 공통 조상 찾는 과정
      ArrayList<String> arr = new ArrayList<>();
      String answer = "";
      while(!n.equals("1")){
        n = nodes.get(n);
        arr.add(n);
      }
      while(!m.equals("1")){
        m = nodes.get(m);
        if(arr.contains(m)){
            answer = m;
            break;
        }
      }
      sum = 1;
      //루트노드가 1이기 때문에 공통 조상이 1이라면 서브 트리의 개수는 전체 정점의 개수와 같음
      if(answer.equals("1")) sum = v;
      else calc(map, answer);
      
      System.out.println("#"+ test_case + " " + answer + " " + sum);
    }
	}

  //서브트리 개수 계산
  static void calc(Map<String, ArrayList<String>> map, String answer){
    if(map.containsKey(answer)) {
      sum += map.get(answer).size();
      for(String tt : map.get(answer)){
        calc(map, tt);
      }
    }
  }
}
