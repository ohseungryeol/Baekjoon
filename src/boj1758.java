import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1758 {
    static class person{
        int money;
        int rank;

        public person(int money, int rank) {
            this.money = money;
            this.rank = rank;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt();
        Integer[] money = new Integer[N];
        ArrayList<person> arr = new ArrayList<>();

        for (int i=0; i<N; i++){
            money[i]=sc.nextInt();
        }


        Arrays.sort(money,Collections.reverseOrder()); //money 내림차순 정렬

        for (int i=0; i<N; i++){
            arr.add(new person(money[i],i+1));
        }

        int tip=0;
        long answer=0;
        for (int i=0; i<arr.size(); i++){
            tip = arr.get(i).money - (arr.get(i).rank-1);
            if(tip>0){
                answer+=tip;
            }
        }

        System.out.println(answer);
    }
}
