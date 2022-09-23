import java.util.Scanner;

public class boj2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){ // 5 4 3 2 1
            arr[i] = sc.nextInt();
        }

        BubbleSort(arr);
    }

    public static void BubbleSort(int[] arr){
        /*배열을 순차탐색하고i, i+1번째 요소를 비교하여 큰 것을 뒤로 이동
        위 과정이 1번 처리되는 경우 가장 큰 수가 배열 마지막에 위치 함다음 탐색부터는 마지막요소는 안해도 됨 ( 그래서 내부에 있는 for문은 arr.length - i 까지만 탐색)
        */
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }


        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }



}
