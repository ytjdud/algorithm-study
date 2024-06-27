package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1697 {
    static int N, K, max, min;
    static int[] loc;
    static boolean[] visited;

    static int[] dx = {-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        K = Integer.parseInt(st[1]);

        int big = Math.max(N, K);
        int small = Math.min(N, K);

        max = big > 1 ? 2*(big-1) : big;
        min = small > 0 ? small/2+1 : 0;

        loc = new int[ max +1];
        visited = new boolean[max +1];

        bfs(N);

        System.out.println(loc[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 0; i < 3 ; i++){
                int nextX;
                if(i == 2){
                    nextX = now * dx[i];
                }else{
                    nextX = now + dx[i];
                }

                if( !(nextX >= min && nextX <= max) )    continue;
                if(visited[nextX])  continue;

                q.add(nextX);
                visited[nextX] = true;

                loc[nextX] = loc[now] + 1  ;
            }

        }
    }
}
