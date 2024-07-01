package boj;

import java.util.Scanner;

public class b9095 {
    static int[] dp = new int[11];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4 ; i < 11 ;i ++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i = 0; i< T; i++){
            int n = scanner.nextInt();

            System.out.println( dp[n] );
        }

    }

}

/**
 *
 * dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
 *
 * 예를 들어, dp[4]는,
 * 3이 만들어지는 모든 경우의 수마다 +1 을 추가해주면 (3+1)
 * 2가 만들어지는 모든 경우의 수마다 +2 을 추가해주면 (2+2)
 * 1이 만들어지는 모든 경우의 수마다 +3 을 추가해주면 (1+3)
 */