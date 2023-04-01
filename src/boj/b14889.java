package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14889 {
    static int[][] arr;
    static int N, diff_min=Integer.MAX_VALUE, N2;
    static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N2 = N/2;
        arr = new int[N][N];
        team = new boolean[N];
        StringTokenizer st;
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(diff_min);
    }

    private static void dfs(int start, int depth) {
        if(depth == N2){
            get_diff_min();
            return;
        }

        for(int i=start;i<N;i++){
            if(!team[i]){
                team[i] = true;
                dfs(i +1, depth+1);
                team[i] = false;
            }
        }
    }

    private static void get_diff_min() {
        int start = 0;
        int link = 0;

        for(int i=0;i<N-1;i++){
            for(int j =i+1; j<N;j++){
                boolean I = team[i];
                boolean J = team[j];
                if(I==J){
                    if(I){
                        start += arr[i][j]+ arr[j][i];
                    }else{
                        link += arr[i][j]+arr[j][i];
                    }
                }
            }
        }

        int diff = Math.abs(start-link);

        if(diff == 0){
            System.out.println(diff);
            System.exit(0);
        }

        diff_min = Math.min(diff, diff_min);
    }
}
