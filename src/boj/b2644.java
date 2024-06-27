package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2644 {
    static int n, a, b, cnt;
    static int[][] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        bfs(a);
        System.out.println(visited[b] > 0 ? visited[b] : -1);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == b){
                return;
            }

            for(int i =1; i<=n; i++){
                if( visited[i] == 0 & arr[now][i] == 1){
                    q.add(i);
                    visited[i] = visited[now] + 1;
                }
            }
        }
    }

}
