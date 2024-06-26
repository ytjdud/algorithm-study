package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10451 {
    static int[] arr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for(int i=0; i<cases; i++){
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            for (int j=1; j<arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            int cnt = 0;

            for(int j=1; j<arr.length; j++){
                if(!visited[j]){
                    dfs(j);
                    cnt ++;
                }
            }

            System.out.println(cnt);

        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        if(!visited[arr[start]]){
            dfs(arr[start]);
        }

    }
}
