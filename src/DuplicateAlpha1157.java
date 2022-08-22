import java.util.Scanner;

public class DuplicateAlpha1157 {
    public static void main(String[] args) {
        /* 가장 많이 사용된 알파벳이 무엇인지 찾는다. 가장많이 사용된 알파벳이 여러개이면 ?를 출력, 1개이면 그 문자를 대문자로 출력 */

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toUpperCase();
        int[] alpha = new int[26];
        char max_alpha = '?';
        for (int i=0; i<str.length(); i++){
            alpha[str.charAt(i)-65]++; //해당 알파벳이 나올때마다 해당인덱스의 값을 증가시킨다.
        }


        int max = 0;
        
        for (int i=0; i<alpha.length; i++){
            if (max<alpha[i]){
                max = alpha[i];
                max_alpha = (char)(i+65);
            } else if (max ==alpha[i]){
                max_alpha ='?';
            }
        }

        System.out.println(max_alpha);

    }
}
