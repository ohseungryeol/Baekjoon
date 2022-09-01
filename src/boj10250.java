import java.util.Scanner;

public class boj10250 {
    public static void main(String[] args) {
        /** 입력1: 테스트 수
         *  입력2: 테스트 수 만큼 H,W,N 을 입력받는다 이떄 H=층 수 W=방 수 N = 몇번쨰 손님
         */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트 수
      //  int[] allocation = new int[T];
        int H,W,N;

        for (int i=0; i<T; i++){
             H = sc.nextInt();
             W = sc.nextInt();
             N =sc.nextInt();
            int room = 101;
            int allocation = room;
            int[][] hotel = new int[H][W];
            for (int row =H-1; row>=0; row--){
                for(int col=0; col<W; col++){
                    hotel[row][col] = room++;
                }
                room= room-W+100;  //101 201 301 401 501 ....
            }

            allocation = hotel[H-(N%H)][N/H];
            System.out.println(allocation);

        }

    //    for (int i=0; i<T; i++){
    //        System.out.println(allocation[i]);
    //    }


    }
}
