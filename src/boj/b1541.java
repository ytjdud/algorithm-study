package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
알게된 것
1.
int i = 0009 는 오류이다. 하지만,
String s = "0009"; int i = Integer.parseInt(s); 는 i=9 가 나온다!

2.
String s = "0009"; s = s.split("\\+"); -> s = 그대로 "0009" 이다!
 */

public class b1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("-");
        int len = S.length;

        int sum=0;
        String[] s = S[0].split("\\+");
        for(String ss:s){
            sum+=Integer.parseInt(ss);
        }

        for(int i=1;i<len;i++){
            String[] ss = S[i].split("\\+");
            int tmp = 0;
            for(String str:ss){
                tmp+=Integer.parseInt(str);
            }
            sum -= tmp;
        }

        System.out.println(sum);
    }
}
