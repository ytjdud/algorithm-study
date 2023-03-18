package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] std = new int[2*n];
        int total=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            std[i] = Integer.parseInt(st.nextToken());
            total += std[i];
        }
        Arrays.sort(std);
        int sm = (int) Math.ceil(total/n);

        for(int i=0,j=2*n-1;i<n;i++,j--){
            if(std[i]+std[j] < sm)  sm = std[i]+std[j];
        }
        System.out.println(sm);
    }
}
