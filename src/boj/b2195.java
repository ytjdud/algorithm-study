package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
first
p(subString of P) 전체에서 뒤에서 하나씩 지워가며 contains 확인
145356KB	360ms

second
앞에서 하나씩, 실제로 P 업데이트가 아닌 idx 로 자른척
11912KB	92ms
 */

public class b2195 {
    static String str, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        P = br.readLine();
        int p_len = P.length();
        int cnt=0;
        for(int i=0, start=0;i<p_len;i++){
            if(str.contains(P.substring(start, i+1))) continue;
            // 이제부터 not contains 이면
            cnt++;
            start = i;

        }
        // 제일 마지막으로 잘린 나머지는 cnt 가 안됨
        System.out.println(cnt+1);
    }
}
