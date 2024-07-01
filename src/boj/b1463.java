package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
//        dp[1] = 0;

        System.out.println( n == 1? 0 : dp(n) );
    }

    private static int dp(int n) {

        if(n == 1)  return 0;
        if(dp[n] != 0 ) return dp[n];

        if( n % 6 == 0){
            dp[n] = Math.min( Math.min( dp(n / 3) + 1, dp( n / 2) + 1 )  , dp(n-1) + 1 );
        }else {

            if (n % 2 == 0) {
                dp[n] = Math.min(dp(n / 2) + 1, dp(n - 1) + 1);
            } else if (n % 3 == 0) {
                dp[n] = Math.min(dp(n / 3) + 1, dp(n - 1) + 1);
            } else { // -1 하기
                dp[n] = dp(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
