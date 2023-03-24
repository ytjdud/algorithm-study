package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 음수와 양수를 가르는 pivot(0) 을 추가하기

public class b1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] pos = new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pos[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pos);

        int pivot=0;
        for(int i=0;i<=N;i++){
            if(pos[i]==0){
                pivot =i;
                break;
            }
        }

        int sum=0;
        // 음수 부분
        for(int i=0;i<pivot;i+=M){
            sum+= (-pos[i]<<1);
        }
        // 양수 부분
        for(int i=N;i>pivot;i-=M){
            sum += (pos[i]<<1);
        }
        System.out.println(sum-Math.max(-pos[0],pos[N]));
    }
}
