package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        int max_loop = N/5;
        for(int i=0; i<=max_loop; i++){
            int tmp = N;

            tmp = (tmp-5*i);
            if(tmp%3 == 0){
                int cnt = tmp/3 + i;
                if(cnt<min) min = cnt;
            }
        }
        if(min == Integer.MAX_VALUE ) System.out.println(-1);
        else System.out.println(min);
    }
}
