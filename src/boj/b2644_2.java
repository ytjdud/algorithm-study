package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2644_2 {
    static int people, p2;
    static boolean[][] relation;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = Integer.parseInt(br.readLine());
        relation = new boolean[people + 1][people + 1];
        visited = new int[people + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int input = Integer.parseInt(br.readLine());

        for(int i  =0; i < input ; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            relation[r1][r2] = relation[r2][r1] = true;
        }

        System.out.println(dfs(p1));

    }

    private static int dfs(int start) {
        if(start == p2){
            return visited[start];
        }

        for(int i = 1; i <= people; i++ ) {
            if(relation[start][i] && visited[i] == 0){
                visited[i] = visited[start] + 1;
                int result = dfs(i);
                if(result != -1) return result;
            }
        }


        return -1;
    }
}
