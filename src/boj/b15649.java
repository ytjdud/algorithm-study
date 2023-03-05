package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649 {
    static boolean[] visited;
    static int[] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];// {1,3} 담고 출력, {1,4} 담고 출력 이럴거
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == M){
            for(int i:arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){ // false 면,
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
