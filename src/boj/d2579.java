package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2579 {
    static int[] stair = new int[301];
    static int[] dp = new int[301];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max( stair[3] + stair[2], stair[3] + stair[1] );

        // 전자: 마지막이 두 계단 + 한 계단 으로 도착, 후자: 두 계단으로 도착
        for(int i = 4; i <= n; i++){
            dp[i] = Math.max( dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i] );
        }

        System.out.println(dp[n]);
    }
}
