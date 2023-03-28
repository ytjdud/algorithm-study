package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken()), i2 = Integer.parseInt(st.nextToken());
            arr[i][0] = i1;
            arr[i][1] = i2;
        }

        Arrays.sort(arr, (a1,a2)->{
            if(a1[0]==a2[0]){
                return a1[1]-a2[1];
            }else{
                return a1[0]-a2[0];
            }
        });

        int start=arr[0][0], end=arr[0][1], sum=0;
        for(int i=1;i<N;i++){
            if(end<arr[i][0]){
                sum += (end-start);
                start = arr[i][0];
                end = arr[i][1];
            }else{
                end = Math.max(arr[i][1],end);
            }
        }
        sum += (end-start);
        System.out.println(sum);
    }
}
