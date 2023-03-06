package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1182 {
    static int N, S, cnt =0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st=  new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        get_sum(0, 0);

        if(S==0)    cnt--;
        System.out.println(cnt);
    }

    private static void get_sum(int idx, int sum) {
        if(idx==N){
            if(sum == S)    cnt++;
            return;
        }
        get_sum(idx+1, sum);
        get_sum(idx+1, sum+arr[idx]);
    }
}
