import java.util.Arrays;

public class callByTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n =13;
        func(n,arr);
        System.out.println(n+","+ Arrays.toString(arr));
    }

    public static void func(int n, int[] arr){
        n=15;
        arr[0]=20;
    }
}
