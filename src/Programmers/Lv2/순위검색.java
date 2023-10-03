package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순위검색 {
    static class Students{
        String lang;
        String job;
        String career;
        String food;
        int score;

        public Students(String lang, String job, String career, String food, int score) {
            this.lang = lang;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
    public int[] solution(String[] info, String[] query) {
        List<Students> stu = new ArrayList<>();
        int[] answer = new int[query.length];

        for (int i=0; i<info.length; i++){
            String tmp = info[i];
            String[] infos = tmp.split(" ");
            String lang = infos[0];
            String job = infos[1];
            String career = infos[2];
            String food = infos[3];
            int score = Integer.parseInt(infos[4]);
            stu.add(new Students(lang, job, career, food, score));
        }

        for (int i=0; i<query.length; i++){
            String tmp = query[i];
            String[] querys = tmp.split("and");
            String[] totalQuery = new String[5];
            totalQuery[0] = querys[0];
            totalQuery[1] = querys[1];
            totalQuery[2] = querys[2];
            String[] foodAndscore = querys[3].split(" ");
            totalQuery[3] = foodAndscore[1];
            totalQuery[4] = foodAndscore[2];


            for (int j=0; j<totalQuery.length; j++){
                totalQuery[j] = totalQuery[j].replaceAll(" ", "");
            }

            String queryLang = totalQuery[0];
            String queryJob = totalQuery[1];
            String queryCareer = totalQuery[2];
            String queryFood = totalQuery[3];
            String queryScore = totalQuery[4];

            answer[i] = querySelect(queryLang, queryJob, queryCareer, queryFood, queryScore, stu);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public int querySelect(String queryLang, String queryJob, String queryCareer, String queryFood, String queryScore,List<Students> stu){
        int querySco = Integer.parseInt(queryScore);
        int count=0;
        for (int i=0; i<stu.size(); i++){
            String lang = stu.get(i).lang;
            String job = stu.get(i).job;
            String career = stu.get(i).career;
            String food = stu.get(i).food;
            int score = stu.get(i).score;

            if((queryLang.equals(lang) || queryLang.equals("-")) &&
                    ((queryJob.equals(job) || queryJob.equals("-")) &&
                            (queryCareer.equals(career) || queryCareer.equals("-")) &&
                            (queryFood.equals(food) || queryFood.equals("-")) &&
            querySco<=score)){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        순위검색 main = new 순위검색();
        main.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
    }
}
