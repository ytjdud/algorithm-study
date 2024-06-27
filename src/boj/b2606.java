package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2606 {
    static int computers;
    static int[][] arr;
    static boolean[] visited;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computers = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        arr = new int[computers + 1][computers + 1];
        visited = new boolean[computers + 1];

        for (int i =0 ; i< t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt-1);

    }

    private static void dfs(int start) {
        visited[start] = true;
        cnt++;

        for(int i = 1 ; i<= computers; i++){
            if(!visited[i] && arr[start][i] == 1){
                dfs(i);
            }
        }
    }
}
