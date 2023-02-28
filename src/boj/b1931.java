package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] t = new int[N][2];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            t[i][0] = Integer.parseInt(st.nextToken());
            t[i][1] = Integer.parseInt(st.nextToken());
        }
        //종료시간 기준으로 정렬하기
        Arrays.sort(t, (t1, t2)->{
            if(t1[1]==t2[1]){
                return t1[0] - t2[0];
            }else {
                return t1[1] - t2[1];
            }
        });

        // 겹치지 않는 부분 count
        int cnt=1, prev=0;
        for (int i=1;i<N;i++){
            if(t[prev][1]<=t[i][0]){
                cnt++;
                prev = i;
            }
        }

        System.out.println(cnt);
    }
}
