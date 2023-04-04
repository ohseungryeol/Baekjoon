package 멋쟁이사자처럼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제4 {
    static class User{
        String name;
        int age;
        String email;

        public User(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public void print(){
            System.out.println("이름: "+this.name+", 나이: "+this.age+", 이메일: "+this.email);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        String name = st.nextToken();
        int age = Integer.parseInt(st.nextToken());
        String email = st.nextToken();

        User user = new User(name,age,email);
        user.print();
    }
}
