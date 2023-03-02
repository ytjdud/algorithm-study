package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];// {1,3} 담고 출력, {1,4} 담고 출력 이럴거
        dfs(N,M,0);
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M){
            for(int i:arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(N,M,depth+1);
                visited[i] = false;
            }
        }
    }
}
