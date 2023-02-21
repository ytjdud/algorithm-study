package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum=0,max=1;

        StringTokenizer st;
        int first = Integer.parseInt(br.readLine().split(" ")[1]);
        int prev = first;
        int now=0;
        for(int i=1; i<6;i++){
            now = Integer.parseInt(br.readLine().split(" ")[1]);
            int sqr = prev*now;
            sum += sqr;
            if(sqr>max) max = sqr;
            prev = now;
        }
        // 마지막 입력*첫번째 입력도 추가
        int last_sqr = first*now;
        sum+= last_sqr;
        if(last_sqr>max) max = last_sqr;

        // 인접한 변1*인접한 변2 값의 합 = ㄱ 2개 + max + (max-ㄱ) == 2max+ㄱ
        // 따라서 sum = 2*max+ㄱ, ㄱ=sum-2*max
        int ans = K*(sum-2*max);
        System.out.println(ans);

    }
}
