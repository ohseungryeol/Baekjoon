package DynammicProgramming;
import java.io.*;
import java.util.*;
public class CodeUp3120 {
    public static void main(String[] args) throws IOException {
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m = "CC#BCC#BCC#BCC#B";
        String answer = "";
        m = changeMelody(m);
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] singInfo = musicinfos[i].split(",");
            String start = singInfo[0];
            String end = singInfo[1];
            singInfo[3] = changeMelody(singInfo[3]);

            int diff = total_minute(end) - total_minute(start);
            int p1 = 0;
            char[] c_melody = singInfo[3].toCharArray();
            String melody = "";
            while (diff > 0) {
                melody += c_melody[p1++];
                if (p1 == c_melody.length) p1 = 0;
                diff--;
            }
            if(melody.contains(m)){
                if(maxTime<melody.length()){
                    answer = singInfo[2];
                    maxTime = melody.length();
                }

            }
        }
        System.out.println(answer);
    }
    public static int total_minute(String time){
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        return hour * 60 + minute;
    }

    public static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "c");
        oldMelody = oldMelody.replaceAll("D#", "d");
        oldMelody = oldMelody.replaceAll("F#", "f");
        oldMelody = oldMelody.replaceAll("G#", "g");
        String newMelody = oldMelody.replaceAll("A#", "a");

        return newMelody;
    }
}
