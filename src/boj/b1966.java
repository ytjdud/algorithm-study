package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 안에 배열 (맵 처럼) {인덱스와 중요도} 를 넣음 - 큐는 인덱싱이 안됨

public class b1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<int[]> q;
        while(T-- >0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            q = new LinkedList<>();
            for(int i=0;i<N;i++){
                q.add(new int[] {Integer.parseInt(st.nextToken()),i}); // {중요도, 인덱스}
            }

            int cnt=0;
            while(true){
                // 현재 큐 중에서 가장 높은 중요도 구하기
                int max=0;
                for(int[] q1:q){
                    if(q1[0] > max)   max = q1[0];
                }

                while(q.element()[0] != max){
                    q.add(q.poll());
                }
                if(q.element()[1] == M){
                    sb.append(++cnt).append('\n');
                    break;
                }else {
                    q.remove();
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}
