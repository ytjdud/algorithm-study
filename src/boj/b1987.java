package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1987 {
    static int R, C;
    static int ans = 0;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        visited = new boolean[R][C];
        for(int i=0; i< R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C ; j++){
                arr[i][j] = st.nextToken();
            }
        }

        dfs(0,0,0);
        System.out.println();
    }

    private static void dfs(int x, int y, int cnt) {
        if(visited[x][y]) {
            ans = Math.max(cnt, ans);
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                dfs(nx, ny, cnt+1);
            }
        }
        visited[x][y] = false;

    }

}
