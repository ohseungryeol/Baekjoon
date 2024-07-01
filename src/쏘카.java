import java.util.*;

public class 쏘카 {
    static class Book implements Comparable<Book>{
        int num;
        int sequence;

        public Book(int num, int sequence) {
            this.num = num;
            this.sequence = sequence;
        }

        @Override
        public int compareTo(Book o) {
            return 0;
        }
    }
    public int solution(int n, int[] orders){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] sequence = new int[500001];
        int answer =0;

        for (int i=0; i<orders.length; i++){
            if(arr.size()==0){
                arr.add(orders[i]);
                sequence[orders[i]]=i;
            } else { //스텍이 비어잇지않으면
                if(arr.get(sequence[orders[i]])!=null){ //뺄때
                    System.out.println(arr.get(sequence[orders[i]]));
                    arr.remove(sequence[orders[i]]);
                    answer+=sequence[orders[i]];
                } else{
                    answer+=stack.size();
                    arr.add(orders[i]);
                    sequence[orders[i]]=i;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        쏘카 쏘카 = new 쏘카();

        쏘카.solution(3, new int[]{1,2,1,3,3,2});
    }
}
