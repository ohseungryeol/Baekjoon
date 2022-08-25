import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] student = new int[n];

        for (int i=0; i<n; i++){
            student[i]= sc.nextInt();
        }

        int count =0;
        int max = student[0];
        for (int i=0; i<student.length-1; i++){
            if (i==0) count++;
            if (max<student[i]) max = student[i];
            if(max<student[i+1]) count++;
        }

        System.out.println(count);
    }


}
