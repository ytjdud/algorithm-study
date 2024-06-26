package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split("");
            for (int j=0; j<M; j++) {
                if(line[j].equals("1")){
                    map[i][j] = 1;
                }
            }
        }

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i = 0; i<4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if( !(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M))    continue;
                if(map[nextX][nextY] == 0)  continue;
                if(visited[nextX][nextY])   continue;

                q.add(new Point(nextX,nextY));
                visited[nextX][nextY] = true;

                map[nextX][nextY] = map[current.x][current.y] + 1;
            }
        }
    }
}
