import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];
		for(int i = 0; i < n; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    String name = st.nextToken();
		    int d = Integer.parseInt(st.nextToken());
		    int m = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    students[i] = new Student(name, d, m, y);
		}
		Arrays.sort(students);
		System.out.println(students[0].name);
		System.out.print(students[n - 1].name);
	}
	static class Student implements Comparable<Student>{
	    String name;
	    int y, d, m;

	    public Student(String name, int d, int m, int y){
	        this.name = name;
	        this.y = y;
	        this.d = d;
	        this.m = m;
	    }
	    @Override
	    public int compareTo(Student s){
	        if(s.y > this.y) return 1;
	        else if(s.y == this.y){
	            if(s.m > this.m) return 1;
	            else if(s.m == this.m){
	                if(s.d > this.d) return 1;
	            }
	        }
	        return -1;
	    }
	    
	}
}
