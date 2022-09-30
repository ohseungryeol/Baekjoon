import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        ArrayList<Point> arr= new ArrayList<>();
        for (int i=0; i<N; i++){
            int x= sc.nextInt();
            int y = sc.nextInt();
            Point s = new Point(x,y);
            arr.add(s);
        }

        Collections.sort(arr);

        for(Point o: arr) System.out.println(o.x+" "+o.y);
    }

    public static class Point implements Comparable<Point>{
        int x,y;
        Point(int x, int y){
            this.x= x;
            this.y= y;
        }
        @Override
        public int compareTo(Point o){
            if(this.x ==o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }

}
