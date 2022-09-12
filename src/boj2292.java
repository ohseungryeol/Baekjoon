import java.util.ArrayList;
import java.util.Scanner;

public class boj2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);

        int i=0;
        int j=6;
        int count=1;
        //  n = 13;
        while(al.get(i)<n){
            al.add(al.get(i)+j);
            j+=6;
            i++;
            count++;
        }

        System.out.println(count);



    }
}
