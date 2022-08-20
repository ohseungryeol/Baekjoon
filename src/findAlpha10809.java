import java.util.Scanner;

public class findAlpha10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // baekjoon

        for(char alpha = 'a'; alpha<='z'; alpha++){
            System.out.print(str.indexOf(alpha)+" "); //a~z가 str문자열에서 처음발견되는 인덱스번호를 출력, 없으면 -1을 출력
        }

    }
}
