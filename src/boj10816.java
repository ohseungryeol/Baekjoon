import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //카드 숫자
        int[] card = new int[N];
        int low =0;
        int high = card.length-1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card); //정렬
        int M = Integer.parseInt(br.readLine()); //찾아야할 카드 갯수
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(card,low,high,key)).append(" ");
        }

        System.out.print(sb);
    }

    public static int binarySearch(int[] card, int low, int high, int key){
        int count=0;
        //int index =-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(card[mid]==key){
                count ++;
                for (int i=mid-1; i>=0; i--){
                    if (card[i]==key) count++;
                    else break;
                }

                for (int i=mid+1; i<card.length; i++){
                    if (card[i]==key) count++;
                    else break;
                }
                break;
            } else if (card[mid]>key){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        return count;
    }

}
