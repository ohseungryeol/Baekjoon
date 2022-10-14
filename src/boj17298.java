import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj17298 {

    static int N;
    static int[] A, res;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        res = new int[N];
        A = new int[N];

        for (int i = 0; i < N; i++)
            res[i] = -1;

        String[] sarr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        A[0] = Integer.parseInt(sarr[0]);
        stack.push(0);

        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(sarr[i]);
            A[i] = n;

            while (!stack.isEmpty() && A[stack.peek()] < n) { //A[index]가 오큰수를 만날때까지 stack에 남아있고 만났다면 해당인덱스의 오큰수가 n이다.
                res[stack.pop()] = n;
            }

            stack.push(i); //인덱스를 푸쉬
        }

        for (int i = 0; i < N; i++)
            bw.write(res[i] + " ");
        bw.flush();

    }
}