import java.util.Arrays;
import java.util.Scanner;

public class boj1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        String[] str = new String[n];

        for (int i=0; i<n; i++){
            str[i] = sc.nextLine();
        }



        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if(str[i].length()>str[j].length()){
                    String tmp =str[i];
                    str[i] = str[j];
                    str[j]=tmp;
                }
            }
        }





    }


}
