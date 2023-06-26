package Simulation;

import java.util.Scanner;

public class boj13022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String str = sc.next();
            System.out.println(isCorrectWolf(str));
            if(str.equals("x")) break;
        }


    }

    public static int isCorrectWolf(String str){
        char lastWord = str.charAt(0);

        if(lastWord!='w') return 0;

        int wCnt =1;
        int oCnt=0;
        int lCnt=0;
        int fCnt=0;

        for (int i=1; i<str.length(); i++){
            char currentWord = str.charAt(i);
            switch (currentWord){
                case 'w':

                    if(lastWord=='w'){
                        wCnt++;
                    } else if (lastWord=='f'){
                        wCnt=1;
                        oCnt=0;
                        lCnt=0;
                        fCnt=0;
                        lastWord='w';
                    } else{
                        return 0;
                    }
                    break;
                case 'o':
                    if(lastWord=='o'){
                        oCnt++;
                    } else if (lastWord=='w'){
                        oCnt++;
                        lastWord='o';
                    } else{
                        return 0;
                    }


                    break;
                case 'l':
                    if(lastWord=='l'){
                        lCnt++;
                    } else if (lastWord=='o'){
                        lCnt++;
                        lastWord='l';
                    } else{
                        return 0;
                    }

                    break;
                case 'f':
                    if(lastWord=='f'){
                        fCnt++;
                    } else if (lastWord=='l'){
                        fCnt++;
                        lastWord='f';
                    } else{
                        return 0;
                    }

                    break;
            }
        }
        System.out.printf("w=%d\n",wCnt);
        System.out.printf("o=%d\n",oCnt);
        System.out.printf("l=%d\n",lCnt);
        System.out.printf("o=%d\n",fCnt);
        if(oCnt!=wCnt) return 0;
        if(lCnt!=wCnt) return 0;
        if(fCnt!=wCnt) return 0;
        //if(oCnt!=wCnt) return 0;
        return 1;
    }
}
