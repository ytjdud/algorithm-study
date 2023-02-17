package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 대칭차집합

public class b1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        HashSet A = new HashSet();
        HashSet B = new HashSet();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a;i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b;i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        //교집합
        A.retainAll(B);

        int total = (a+b) - A.size()*2 ;

        System.out.println(total);
    }
}
