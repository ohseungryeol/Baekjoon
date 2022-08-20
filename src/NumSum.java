import java.util.Scanner;

public class NumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str =sc.next();
        String[] strSplit = new String[n];
        strSplit = str.split("");
        int sum=0;

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(strSplit[i]);
            sum+=num;
        }

        System.out.println(sum);


    }
}
