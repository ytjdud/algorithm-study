package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// p(subString of P) 전체에서 뒤에서 하나씩 지워가며 contains 확인
// 145356KB	360ms

public class b2195 {
    static String str, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        P = br.readLine();
        int cnt=0;
        while(P.length() > 0){
            int start = Math.min(P.length(), str.length());
            P = get_s(start, P);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static String get_s(int start, String p) {
        for(int i=start;i>=0;i--){
            if(str.contains(p.substring(0,i))){
                return p.substring(i);
            }
        }
        return "";
    }
}
