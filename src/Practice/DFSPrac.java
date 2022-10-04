package Practice;

public class DFSPrac {
    public static class Node {
        int data;
        Node lt,rt;
        Node(int data){
            this.data= data;
            this.lt =null;
            this.rt =null;
        }
    }
    public static void DFS(Node root){
        if(root ==null){
            return;
        } else{

            DFS(root.lt);
            DFS(root.rt);
            System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }

}
