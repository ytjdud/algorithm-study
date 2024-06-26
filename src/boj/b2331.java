package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2331 {
    static final int MAX = 236196;
    static int[] visited = new int[MAX + 1];
    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        P = Integer.parseInt(inputs[1]);

        dfs(A);

        int cnt = 0;
        for(int i =1; i<=MAX; i++){
            if(visited[i] == 1) cnt++;
        }

        System.out.println(cnt);

    }

    private static void dfs(int now) {
        visited[now]++;
        if(visited[now] == 3){
            return;
        }

        int origin = now;
        int next = 0;
        do {
            next += (int) Math.pow(now %10, P);
            now /= 10;
        } while (now > 0);

        dfs(next);

        if(visited[origin] == 1);

    }
}
