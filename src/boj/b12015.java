package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
최장 증가 수열 (LIS, Longest Increasing Subsequence)
lower bound - ex) 1 2 3 6 7 9, put 4 가능한 모든 수(6 7 9) 중에서 제일 작은 수
 */

public class b12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] LIS = new int[N];
        LIS[0] = A[0];
//        LIS[1] = A[1]; 입력된 A[] 길이가 1 뿐 일 수도
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
