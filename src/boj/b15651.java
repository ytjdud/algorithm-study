package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15651 {
    static int[] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        for(int i=1;i<=N;i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
