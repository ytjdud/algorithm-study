package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] s = new String[N];

        for(int i=0;i<N;i++){
            s[i] = br.readLine();
        }

        Arrays.sort(s, (s1, s2) ->{
            if(s1.length() == s2.length()){
                return s1.compareTo(s2); // string 은 '-' 사용할 수 없음. compareTo() 이용
            }else{
                return s1.length() - s2.length();
            }
        });

        // 중복체크하기!!
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]).append('\n');
        for(int i=1;i<N;i++){
            if(!s[i-1].equals(s[i])){
                sb.append(s[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
