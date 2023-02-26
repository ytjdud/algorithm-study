package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] LIS = new int[N];
        LIS[0] = A[0];
        int len=1; // len of LIS[]

        int[] idx = new int[N]; // A[i] 가 LIS[] 에서 몇번째 인덱스에 쓰였는가
        Arrays.fill(idx,-1); // for문 돌리는 것보다 효율적
        idx[0] = 0;

        for(int i=1;i<N;i++){ // i for A[]
            int v = A[i];
            if(LIS[len-1] < v){
                LIS[len] = v;
                idx[i] = len;
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
                idx[i] = lo;
            }
        }
        // idx[] 뒤에서부터 순차로 idx 54321.. 가장 먼저 나오는 인덱스의 i 가 정답수열에 들어갈 A[i]
        Stack<Integer> st = new Stack<>();
        int ind = len-1;
        for(int i =N-1;i>=0;i--){
            if(idx[i] == ind){
                int a = A[i];
                st.push(a);
                ind--;
            }
            if(ind == -1)    break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');
        for(int i=0;i<len;i++){
            sb.append(st.pop()).append(' ');
        }
        System.out.println(sb);
    }

}
