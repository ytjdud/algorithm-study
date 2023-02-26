package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
최장 증가 수열 (LIS, Longest Increasing Subsequence)
lower bound
ex) 1 2 3 6 7 9, put 4 <- 3보다 큰 모든 수 중 가장 작은 수
ex) -8 -7 -6 -5 -2 -1 put -3 <- -3 보다 큰 모든 수 중 가장 작은 수
**lower bound : 찾고자 하는 값이 처음 나타나는 곳
**upper bound : 찾고자 하는 값보다 큰 값이 처음 나타나는
 */

// 12015, 12738 코드 동일
public class b12015_12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] LIS = new int[N];
        LIS[0] = A[0];
        int len=1; // len of LIS[]
        for(int i=1;i<N;i++){ // i for A[]
            int v = A[i];
            if(LIS[len-1] < v){
                LIS[len] = v;
                len++;
            }else if(LIS[len-1] > v){
                // lower bound
                int lo=0, hi=len,mid;
                while(lo<hi){
                    mid = (lo+hi)/2;
                    if(LIS[mid] < v){
                        lo = mid+1;
                    }else{
                        hi = mid;
                    }
                }
                LIS[lo] = v;
            }
        }
        System.out.println(len);
    }
}
