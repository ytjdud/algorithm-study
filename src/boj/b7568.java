package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어렵게 생각하지 말것. 굳이 rank를 매길때 전체적으로 파악할 필요 없다.

public class b7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] person = new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int rank = 1;
            for(int j=0;j<N;j++){
                if(i==j)    continue;
                if(person[i][0]<person[j][0] && person[i][1]<person[j][1])  rank++; // j 가 클수록 rank 내려감
            }
            sb.append(rank).append(' ');
        }
        System.out.println(sb);
    }
}
