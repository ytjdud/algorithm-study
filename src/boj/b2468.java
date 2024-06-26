package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int low=100, high=1;
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n < low) low = n;
                if(n > high)    high = n;
                map[i][j] = n;
            }
        }

        if(low == high){
            System.out.println(1);
            return;
        }

        int max = 0;
        for(int h = low; h < high; h++){
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i = 0; i< N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > h && !visited[i][j]){
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            if(cnt > max)   max = cnt;
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y, int level) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i =0; i< 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if( !(nextX>=0 && nextX<N && nextY>=0 && nextY<N) ) continue;
                if ( !(map[nextX][nextY] > level) ) continue;
                if( visited[nextX][nextY] ) continue;

                q.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }

    }
}
