package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15655 {
    static int N,M;
    static int[] arr;
    static int[] write;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 4
        M = Integer.parseInt(st.nextToken()); // 2
        write = new int[M];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if(depth == M){
            for(int i:write){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i<N;i++){
            write[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}
