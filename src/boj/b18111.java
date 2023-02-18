package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] field = new int[N][M];
        int min=256, max=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                field[i][j] = n;
                if(n<min)   min = n;
                else if(n>max)   max = n;
            }
        }

        int max_height=0, min_time=N*M*(max-min)*2;
        for(int i=min;i<=max;i++){
            int nth_time =0;
            int inv=0;
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    int height_diff = field[x][y]-i;
                    if (height_diff > 0 ){
                        nth_time += height_diff*2;
                    }else if(height_diff < 0){
                        nth_time -= height_diff;
                    }
                    inv += height_diff;
                }
            }
            if( B+inv>=0 && nth_time<=min_time){
                min_time = nth_time;
                max_height = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min_time).append(' ').append(max_height);
        System.out.println(sb);
    }

}
