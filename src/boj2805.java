import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805 {
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //나무의 수
        int m = Integer.parseInt(st.nextToken()); //가져가려는 나무의 길이

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i]=num;
        }
        Arrays.sort(arr);
        System.out.println(findTree(arr,m));
    }

    public static int findTree(int[] arr, int m){

        int low =arr[0];
        int high = arr[arr.length-1];

        while(low<=high){
            int mid = (low+high)/2; //25
            long sum=0;
            for (int i=0; i<arr.length; i++) {
                if(arr[i]>mid){
                    sum+=(arr[i]-mid);
                }
            }
            if (sum>m){
                low = mid+1;
            } else if(sum<m) {
                high = mid-1;
            } else if (sum==m){
                return mid;
            }
        }

        return high;
    }
}
