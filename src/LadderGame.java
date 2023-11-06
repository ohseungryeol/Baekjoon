public class LadderGame {
    public static void main(String[] args) {
        int[][] ladder = {
                {1, 0, 1},
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };
        int n = 4; // 참가자의 수

        int[] result = playLadderGame(ladder, n);

        // 결과 출력
        System.out.println("참가자 번호: 도착 지점");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ": " + result[i]);
        }
    }

    public static int[] playLadderGame(int[][] ladder, int n) {
        int[] result = new int[n]; // 참가자의 도착 지점 저장

        // 사다리 게임 진행
        for (int i = 0; i < n; i++) {
            int col = i; // 현재 열
            for (int row = 0; row < ladder.length; row++) {
                if (col > 0 && ladder[row][col - 1] == 1) {
                    // 왼쪽으로 이동
                    col--;
                } else if (col < ladder[0].length && ladder[row][col] == 1) {
                    // 오른쪽으로 이동
                    col++;
                }
            }
            // 도착 지점 저장
            result[i] = col+1;
        }

        return result;
    }
}
