package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {
    static int m, n;
    static int ripes=0;
    static int[][] box;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int a = Integer.parseInt(st.nextToken());
                box[i][j] = a;

                if(a==0)    ripes++;
                if(a==1)    q.add(new Point(i,j));
            }
        }

        int min = bfs(q) - 1 ;
        System.out.println(ripes == 0? min: -1);

    }

    private static int bfs(Queue<Point> start) {
        Queue<Point> q;
        q = start;

        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                Point now = q.poll();

                for(int j =0; j< 4; j++){
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];

                    if( !(nextX>=0 && nextX < n && nextY >= 0 && nextY < m) )   continue;
                    if( box[nextX][nextY] != 0 )   continue;

                    box[nextX][nextY] = 1;
                    q.add(new Point(nextX,nextY));

                    ripes--;
                }
            }
            depth ++ ;
        }
        return depth;
    }
}
