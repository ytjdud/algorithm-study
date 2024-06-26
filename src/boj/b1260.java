package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[] check;

    static int nodes;
    static int lines;
    static int start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodes = Integer.parseInt(st.nextToken());
        lines = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[nodes+1][nodes+1];

        for(int i = 0; i < lines; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        check = new boolean[nodes+1];
        dfs(start);

        sb.append("\n");

        check = new boolean[nodes+1];
        bfs(start);

        System.out.println(sb);

    }

    private static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for(int i = 1; i <= nodes; i++){
                if( arr[start][i] == 1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }

    }

    private static void dfs(int start) {

        check[start] = true;
        sb.append(start + " ");

        for(int i = 1; i <= nodes; i++){
            if(arr[start][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }
}
