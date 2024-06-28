package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1987_2 {
    static int R, C;
    static int[][] board;
    static boolean[] visited = new boolean[26 +1]; // 알파벳 개수: 26개

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for(int i = 0; i< R; i++){
            String line = br.readLine();
            for(int j = 0; j< C; j++){
                board[i][j] = line.charAt(j) - 64;
            }
        }

        dfs(new Point(0,0), 0);

        System.out.println(max);
    }

    private static void dfs(Point start, int pass) {
        int startLetter = board[start.x][start.y];

        if( visited[startLetter]){
            max = Math.max(max, pass);
            return;
        }

        visited[startLetter] = true;

        for(int i = 0; i< 4; i++){
            int nextX = start.x + dx[i];
            int nextY = start.y + dy[i];

            if( nextX>=0 && nextX<R && nextY>=0 && nextY<C ) {
                dfs(new Point(nextX, nextY), pass + 1);
            }
        }

        visited[startLetter] = false;
    }

}
