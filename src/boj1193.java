import java.util.Scanner;

public class boj1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int line = 0; //
        int cnt =0;

        while(cnt<n){   //5 . line= 3 cnt =6 7. line = 4 cnt = 10
            line++;
            cnt = line*(line+1)/2;
        }

        if (line%2 ==0 ){//짝수이면
            int top = line - (cnt - n);
            int bottom = 1 + (cnt - n);
            System.out.println(top+"/"+bottom);
        } else{
            int top = 1 + (cnt - n);
            int bottom = line - (cnt - n);
            System.out.println(top+"/"+bottom);
        }


    }
}
