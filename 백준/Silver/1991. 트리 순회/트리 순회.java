import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node('A', null, null);
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char v = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            
            insertNode(root, v, l, r);
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
    static class Node{
        char v;
        Node l, r;
        
        public Node(char v, Node l, Node r){
            this.v = v;
            this.l = l;
            this.r = r;
        }
    }
    public static void insertNode(Node tmp, char v, char l, char r){
        if(tmp.v == v){
            tmp.l = (l == '.' ? null : new Node(l, null, null));
            tmp.r = (r == '.' ? null : new Node(r, null, null));
        }
        else{
            if(tmp.l != null) insertNode(tmp.l, v, l, r);
            if(tmp.r != null) insertNode(tmp.r, v, l, r);
        }
    }
    
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.v);
        preOrder(root.l);
        preOrder(root.r);
    }
    
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.l);
        System.out.print(root.v);
        inOrder(root.r);
    }
    
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.l);
        postOrder(root.r);
        System.out.print(root.v);
    }
}
