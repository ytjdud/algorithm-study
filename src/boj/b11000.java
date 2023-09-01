package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] time = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, (t1,t2)->{
            return t1[0] - t2[0];
        }); // 이중 비교가 필요없는 문제

        pq.add(time[0][1]); // end time 만 알아도 됨!!
        for(int i=1;i<N;i++) {
            if (pq.peek() <= time[i][0]) {
                pq.poll();
            }
            pq.add(time[i][1]);
        }
        System.out.println(pq.size());
    }
}
