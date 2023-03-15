package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int total_of_once = 0;
        for(int i=1;i<n;i++){
            int m = Integer.parseInt(st.nextToken());
            if(m>max){
                total_of_once += max;
                max = m;
                continue;
            }
            total_of_once += m;
        }
        total_of_once += max * (n-1);
        System.out.println(total_of_once);
    }
}
