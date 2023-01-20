import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    ArrayList<Node> child = new ArrayList<>();

    String num; //자신의 번호
    public Node(String num){
        this.num = num;

    }
}
public class boj1068 {
    static Node root; // 초기 root는 null
    static ArrayList<Node> Tree = new ArrayList<>();
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            String num = String.valueOf(i);
            Tree.add(new Node(num));
        }

        for (int i=0; i<N; i++){
            int parent = Integer.parseInt(st.nextToken()); // -1 0 0 1 1
            if(parent ==-1 ){
                root = Tree.get(i);
                continue;
            }
            Tree.get(parent).child.add(Tree.get(i));
        }

        int delNum = Integer.parseInt(br.readLine()); //1
        deleteNode(delNum);
        for (int i=0; i<Tree.size(); i++){
            System.out.println(Tree.get(i).num);
        }

        System.out.println(count);

    }

    public static void deleteNode(int delNum){
        String del = String.valueOf(delNum);
        for (Node child: Tree.get(delNum).child){
            Tree.remove(child.num);
        }
        Tree.remove(del);

    }




}
