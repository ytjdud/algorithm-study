package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1920 {
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        L:
        for(int target:B){
            int start =0, end=A.length-1, mid = (start+end)/2; // end=M-1 의 반례 : N 배열보다 M 배열이 클때
            while(start <= end){
                if(target == A[mid]){
                    sb.append(1).append('\n');
                    continue L; // 이런거 안할려면 for 문 내 함수를 함수로 뺀다.
                } else if (target < A[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
                mid = (start+end)/2;
            }
            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}
