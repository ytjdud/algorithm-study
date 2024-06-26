package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class b2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i <N; i++){
            String[] st = br.readLine().split("");
            for(int j =0; j <N; j++){
                if(st[j].equals("1"))   map[i][j] = 1;
            }
        }

        int cnt = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i< N; i++){
            for(int j =0;j<N;j++){
                if( map[i][j]==1 && !visited[i][j]){
                    int houses = bfs(i,j);
                    al.add(houses);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        Collections.sort(al);
        for (Integer i : al) {
            System.out.println(i);
        }

    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        int houses = 1;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i = 0; i<4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if( !(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N))    continue;
                if(map[nextX][nextY] == 0)  continue;
                if(visited[nextX][nextY])   continue;

                q.add(new Point(nextX,nextY));
                visited[nextX][nextY] = true;
                houses++;
            }
        }

        return houses;
    }
}
