package boj2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(reader.readLine());
        int[][] ballInfo = new int[tries][3];
        for (int i = 0; i < tries; i++) {
            StringTokenizer countTokens = new StringTokenizer(reader.readLine());
            ballInfo[i] = new int[]{
                    Integer.parseInt(countTokens.nextToken()), //부른 숫자
                    Integer.parseInt(countTokens.nextToken()), //스트라이크 갯수
                    Integer.parseInt(countTokens.nextToken())  // 볼 갯수
            };
        }

        // 모든 조건을 만족하는 숫자의 갯수
        int answer = 0;

        for (int i = 1; i < 10; i++) {  // 1부터 9까지
            for (int j = 1; j < 10; j++) {
                if (i == j) continue; //
                for (int k = 1; k < 10; k++) {
                    if (k == i || k == j) continue; //자리마다 중복은 안된다.
                    // 모든 질문에 대하여 조건이 일치하는지를 확인하다,
                    // 하나라도 틀릴경우 flag = false를 진행한다. 이후

                    boolean flag = true;
                    // 확인을 위해 숫자를 자리 단위로 나눠야 하기 때문에 굳이 하나의 숫자로
                    // 합치지 않는다.
                    int[] select = new int[]{i, j, k}; //루프를 돌때마다 선택된 3자리수
                    for (int t = 0; t < tries; t++) {
                        int target = ballInfo[t][0];
                        int[] result = getCount(target, select); //3 ,0
                        //getCount 함수를 통해 나올 수 있는 경우의 수인 select와 민혁이가 부른 숫자 target이
                        if (result[0] != ballInfo[t][1] || result[1] != ballInfo[t][2]) {
                            //민혁이가 부른 숫자들 중에서 하나라도 strike, ball 판정이 틀리면 정답 후보가 될 수없다.
                            flag = false;
                            break;
                        }
                    }
                    // 민혁이가 부른 숫자들 strike, ball판정 여부를 모두 마치고 flag == true 일때만 모든 입력 예시의 조건이 모두 만족한 것
                    if (flag) answer++;
                }
            }
        }

        return answer;
    }

    // 민혁이가 부른 숫자 target과 for문에서 선택된 경우의 수 select와 비교해서 스트라이크와 볼의 갯수를 판단하는 메소드이다.
    private int[] getCount(int target, int[] select) {
        // tartget 숫자를 select 배열과 비교를 위해 자릿수마다 배열화
        int[] targetNums = new int[]{target / 100, (target / 10) % 10, target % 10};
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            // target 배열과 select 배열에 i번째 인덱스 값이 동일하면 strike이다.
            if (targetNums[i] == select[i]) strikes++;
                // 아니라면
            else {
                // i번째 인덱스 값이 동일하지 않으면 다른 인덱스에 i번째 인덱스 값이 존재하나 확인 -> 존재하면 ball이다.
                for (int j = 0; j < 3; j++) {
                    if (targetNums[j] == select[i]) balls++;
                }
            }
        }
        return new int[]{strikes, balls};
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}