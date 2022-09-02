import java.util.Scanner;

public class boj17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        String[] word = str.split(" ");

        for (String x : word) {
            String tmp = new StringBuilder(x).reverse().toString();
            System.out.print(tmp + " ");
        }

        for(int i=0; i<ch.length; i++){
          // if(ch[i]=='<')
        }
    }
}
