import java.util.Scanner;

public class Croatia2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str ="c=c-dz=d-ljnjs=z=";
        String[] strArr = str.split("=");

        for(String x: strArr){
            System.out.println(x);
        }
    }
}
