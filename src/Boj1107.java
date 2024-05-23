import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String goal = br.readLine();
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 횟수
        boolean upten = false;
        HashSet<Integer> breakButton = new HashSet<>();
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                breakButton.add(Integer.parseInt(st.nextToken()));
            }
        }
        //리모컨: 0~9 , +, - 버튼
        //100에서 시작하므로 98 99 100 101 102 범위는 3미만에 가능

        int start = 100;
        int goalToNum = Integer.parseInt(goal);
        int count = 0;
        String str = "";

        if (goalToNum >= 98 && goalToNum <= 102) {
            if (goalToNum < start) {
                while (goalToNum != start) {
                    count++;
                    start--;
                }
            } else {
                while (goalToNum != start) {
                    count++;
                    start++;
                }
            }
            System.out.println(count);
            return;
        }

        int num1 = Integer.parseInt(String.valueOf(goal.charAt(0)));
        if (!breakButton.contains(num1) || breakButton.isEmpty()) {
            str += goal.charAt(0);
            count++;

        } else { //고장난 버튼이라면
            int plusNum = num1;
            int minusNum = num1;
            int pCount = 0;
            int mCount = 0;

            while (true) {
                pCount++;
                if (!breakButton.contains(++plusNum)) {
                    break;
                }
            }
            while (true) {
                mCount++;
                if (!breakButton.contains(--minusNum)) {
                    break;
                }
            }

            if (mCount < pCount) str += minusNum;
            else str += plusNum;
            count++;
        }

        boolean flag = false;
        for (int i = 1; i < goal.length(); i++) {
            //앞자리부터
            if (flag) break;
            int num = Integer.parseInt(String.valueOf(goal.charAt(i)));
            int prevStrNum = Integer.parseInt(String.valueOf(str.charAt(i - 1)));
            int prevGoalNum = Integer.parseInt(String.valueOf(goal.charAt(i - 1)));
            //직전 숫자가 작았는지.-> 작았다면 큰 숫자부터 대입
            // 70000 80000 -> 77777
            if (prevStrNum < prevGoalNum) {
                int idx = i;
                for (int j = idx; j < goal.length(); j++) {
                    for (int k = 9; k >= 0; k--) {
                        if (!breakButton.contains(k)) {
                            str += k;
                            count++;
                            break;
                        }
                    }
                }
                flag = true;
            } else if (prevStrNum > prevGoalNum) {
                int idx = i;
                for (int j = idx; j < goal.length(); j++) {
                    for (int k = 0; k <= 9; k++) {
                        if (!breakButton.contains(k)) {
                            str += k;
                            count++;
                            break;
                        }
                    }
                }
                flag = true;
            } else if (prevStrNum == prevGoalNum) {
                if (!breakButton.contains(num) || breakButton.isEmpty()) {
                    str += goal.charAt(i);
                    count++;

                } else { //고장난 버튼이라면
                    int plusNum = num; // 7
                    int minusNum = num;

                    int pCount = 0;
                    int mCount = 0;

                    while (true) {
                        pCount++;
                        if (!breakButton.contains(++plusNum)) {
                            break;
                        }
                    }
                    while (true) {
                        mCount++;
                        if (!breakButton.contains(--minusNum)) {
                            break;
                        }
                    }

                    if (mCount < pCount) str += minusNum;
                    else str += plusNum;
                    count++;
                }

            }

        }

        int strToNum = Integer.parseInt(str);
        System.out.println(strToNum);

        if (goalToNum < strToNum) {
            while (strToNum != goalToNum) {
                strToNum--;
                count++;
            }
        } else {
            while (strToNum != goalToNum) {
                strToNum++;
                count++;
            }
        }

        System.out.println(count);

//        1555
//        3
//        0 1 9
    }
}
