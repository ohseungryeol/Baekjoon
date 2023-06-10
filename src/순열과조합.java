import java.util.Arrays;

public class 순열과조합 {
    static int r,n;
    static int[] result;
    static int[] stu = {1,2,3,4,5};
    static int[] check = new int[5];
    public static void main(String[] args) {

        n =5; //학생 수
        r =2; //뽑는 학생 수
        result = new int[2];
        repeatedCombination(0,0);
    }

    public static void repeatedpermutation(int L){ // 순서가 있는 경우의 수 -> 회장 부회장 선출 (중복 있음) 한명이 회장 부회장 둘다 가능
        if (L==r){
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i=0; i<n; i++){
            result[L]=stu[i];
            repeatedpermutation(L+1);
        }
    }

    public static void permutation(int L){ //순서가 있는 경우의 수 -> 회장 부회장 선출(중복 없음) 한명이 회장 부회장 둘 다하는 것은 불가
        if (L==r){
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i=0; i<n; i++){
            if(check[i]==0) {
                check[i]=1;
                result[L] = stu[i];
                permutation(L + 1);
                check[i]=0;
            }
        }

    }

    public static void repeatedCombination(int start, int L){
        if (L==r){
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i=start; i<n; i++){
            if(check[i]==0) {
                check[i]=1;
                result[L] = stu[i];
                repeatedCombination(start + 1, L + 1);
                check[i]=0;
            }
        }
    }
}
