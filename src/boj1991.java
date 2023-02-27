import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 {
     static class Node{
        char data;
        Node lt,rt;
        public Node(char n) {
            this.data = n;
            lt=rt=null;
        }
    }

    static Node root = new Node('A');
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char mid = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            InsertNode(root,mid,left,right);
        }

        PreOrder(root);
        System.out.println();
        InOrder(root);
        System.out.println();
        PostOrder(root);
    }

    public static void InsertNode(Node temp, char mid,char left, char right){

        if (temp.data ==mid){
            if (left!='.') temp.lt = new Node(left);
            if (right!='.') temp.rt = new Node(right);
        } else{
            if(temp.lt!=null) InsertNode(temp.lt,mid,left,right);
            if(temp.rt!=null) InsertNode(temp.rt, mid, left, right);
        }
    }

    public static void PreOrder(Node root){
        if(root == null){
            return;
        } else{
            System.out.print(root.data);
            PreOrder(root.lt);
            PreOrder(root.rt);
        }
    }

    public static void PostOrder(Node root){
        if(root == null){
            return;
        } else{
            PostOrder(root.lt);
            PostOrder(root.rt);
            System.out.print(root.data);
        }
    }

    public static void InOrder(Node root){
        if(root == null){
            return;
        } else{
            InOrder(root.lt);
            System.out.print(root.data);
            InOrder(root.rt);

        }
    }
}
