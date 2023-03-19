package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] puddles = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(puddles, (p1,p2)->{
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            }else{
                return p1[0] - p2[0];
            }
        });

        int cnt=0, next_start=0;
        for(int[] p:puddles){
            if(p[0]>next_start){
                next_start = p[0];
            }

            while(p[1]>next_start){
                next_start += L;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
