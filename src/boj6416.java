import java.util.*;

public class boj6416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> U;
        HashSet<Integer> V;



        int checkExit = 0;
        int test =1;
        while(true){
            boolean isTree = true;
            int root =0;
            U= new HashSet<>();
            V = new HashSet<>();

            while(true){
                int u = sc.nextInt();
                int v = sc.nextInt();

                if (u==0 && v==0){
                    Iterator<Integer> vIter= V.iterator();
                    Iterator<Integer> uIter= U.iterator();
                    if(U.size()>0) { //비어있는 트리 구분
                        while (uIter.hasNext()) {
                            if (!V.contains(uIter.next())) root++; // 들어오는 간선이 없는 노드이면 root
                        }

                        if (root != 1) isTree = false;
                    }
                    break;
                } else if (u==-1 && v==-1){
                    return;
                } else{
                    U.add(u);
                    if(V.contains(v)){ //들어오는 간선이 2개이상 있으면 트리가 아니다. 즉 부모가 2개 이상 있을 수 없다.
                        isTree=false;
                    } else{
                        V.add(v);
                    }

                }
            }
            if(isTree){
                System.out.println("Case " + test + " is a tree.");
            } else{
                System.out.println("Case " + test + " is not a tree.");
            }
            test++;
        }

    }
}
